<?php

namespace App\Http\Controllers\Api\Auth;

use App\Admin;
use App\Deacons;
use App\Elders;
use App\Http\Controllers\Controller;
use App\Members;
use App\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Laravel\Passport\Client;
use PDO;

class Register extends Controller
{
    //

    protected $verificationController;
    protected $client;

    public function __construct(VerificationController $verificationController)
    {
        $this->verificationController = $verificationController;
        $this->client = Client::find(2);

    }


    public function registerClergy(Request $request){

        $this->validate($request, [
            'name'=> 'required',
            'email'=> 'required|email|unique:users,email',
            'status' => 'required',
            'committment' => 'required',
            'phone_number' => 'required',
            'age' => 'required',
            'gender' => 'required',
            'marriage_status' => 'required'

        ]);

        $user = new User();
        $user->name = $request->name;
        $user->email = $request->email;
        $user->status = $request->status;
        $user->phone_number = $request->phone_number;
        $user->age = $request->age;
        $user->gender  = $request->gender;
        $user->marriage_status = $request->marriage_status;
        $user->committment = $request->committment;

        if($request->hasFile('image')){

            $image = $request->file('image');
            $user->image = $image->store("uploads/hop/logo");

        }


        if($request->status == 'deacons'){

            $deacon = new Deacons();
            $deacon->user_id = $user->id;
            $deacon->on_duty = 0;
            $deacon->active = 1;
            $deacon->description = $request->description;
            $deacon->qualification = $request->qualifications;
            $deacon->assigned_tasks = "unassigned";
            $user->save();

            if($deacon->save()){

                return response()->json(['Success'=> 'Deacon has successfully been added...']);

            }else{
                return response()->json(['Error' => 'Something went wrong...']);
            }

        }elseif($request->status == 'elders'){

            $elders = new Elders();
            $elders->user_id = $user->id;
            $elders->on_duty = 0;
            $elders->active = 1;
            $elders->description = $request->description;
            $elders->qualification = $request->qualifications;
            $elders->assigned_tasks = "unassigned";
            $user->save();

            if($elders->save()){

                return response()->json(['Success'=> 'Elder has successfully been added...']);

            }else{
                return response()->json(['Error' => 'Something went wrong...']);
            }

        }elseif($request->status == 'admin'){

            $user->password = Hash::make($request->password);
            $admin = new Admin();
            $admin->user_id = $user->id;
            $admin->description = $request->description;
            $admin->qualification = $request->qualifications;
            $admin->assigned_tasks = "unassigned";
            $user->save();

            if($admin->save()){

                $this->verificationController->resend($request->email);
                return response()->json(['Success'=> 'Admin has successfully been added... confirm email']);

            }else{
                return response()->json(['Error' => 'Something went wrong...']);
            }

        }else{
            $user->password = Hash::make("12345678");
            $user->save();
            $member = new Members();
            $member->active_status = 1;
            $member->user_id = $user->id;

            $member->save();

            return response()->json(['Success'=> 'Member has successfully been added...']);
        }
    }

    function generateRandomString($length = 10)
    {
        $characters = '123456789ABCDEFGHIJKLMNPQRSTUVWXYZ';
        $charactersLength = strlen($characters);
        $randomString = '';
        for ($i = 0; $i < $length; $i++) {
            $randomString .= $characters[rand(0, $charactersLength - 1)];
        }
        return $randomString;
    }


}

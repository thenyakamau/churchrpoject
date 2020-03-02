<?php

namespace App\Http\Controllers\Api\Auth;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use Laravel\Passport\Client;

class Login extends Controller
{
    //

    use IssueTokenTrait;

    protected $client;

    public function __construct()
    {
        $this->client = Client::find(2);
    }

    public function admin_login(Request $request){

        $this->validate($request, [
            'username' => 'required|email',
            'password' => 'required|min:8|max:20'
        ]);

        $this->issueToken($request, 'password');

    }

    public function refresh(Request $request){


        $this->validate($request, [

            'refresh_token' => 'required'

        ]);

       return $this->issueToken($request,'refresh_token');

    }

    public function logout(Request $request){

        $accessToken = Auth::user()->token();

        DB::table('oauth_refresh_tokens')
            ->where('access_token_id', $accessToken->id)
            ->update(['revoked' => true]);

        $accessToken->revoke();

        return response()->json([], 204);

    }
}

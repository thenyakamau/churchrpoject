<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Members;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;

class MembersController extends Controller
{
    //

    public function fetchChurchMembers(){

        $members = Members::paginate();

        return response()->json(['churchMembers'=> $members]);

    }

    public function fetchMembersStatics(){

        $members = Members::count();
        $children = Members::where('age','<=', '12')->where('status', 'members')->count();
        $youth = Members::where('age','<=', '35')->where('status', 'members')->count();
        $elders = Members::where('age','>', '35')->where('status', 'members')->count();

        return response()->json(['membersCount'=>$members, 'childrenCount'=>$children, 'youth' =>$youth, 'elders'=>$elders]);

    }

    public function searchMembers(Request $request){

        $searchData = DB::table('members')
        ->join('user', 'members.user_id', Auth::user()-> id)
        ->select('*')
        ->where('user.name', 'like', '%' . $request->query . '%')
        ->orWhere('user.email', 'like', '%' . $request->query . '%');


        return response()->json(['churchMembers'=> $searchData]);

    }
}

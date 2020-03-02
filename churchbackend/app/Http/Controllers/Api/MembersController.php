<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Members;
use Illuminate\Http\Request;

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
}

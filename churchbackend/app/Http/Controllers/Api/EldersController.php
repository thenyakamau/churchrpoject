<?php

namespace App\Http\Controllers\Api;

use App\Elders;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class EldersController extends Controller
{
    //

    public function fetchElders(){

        $elders = Elders::paginate();

        return response()->json(['churchElders'=>$elders]);

    }

}

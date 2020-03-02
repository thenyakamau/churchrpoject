<?php

namespace App\Http\Controllers\Api;

use App\Deacons;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class DeaconsController extends Controller
{
    //

    public function fetchDeacons(){

        $deacons = Deacons::paginate();

        return response()->json(['churchDeacons'=> $deacons]);

    }
}

<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Deacons extends Model
{
    //

    public function user(){

        $this->belongsTo(User::class);

    }
}

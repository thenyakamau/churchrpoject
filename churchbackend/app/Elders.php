<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Elders extends Model
{
    //

    public function user(){

        $this->belongsTo(User::class);

    }
}

<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Members extends Model
{
    //

    public function user(){

        $this->belongsTo(User::class);

    }
}

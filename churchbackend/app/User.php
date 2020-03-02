<?php

namespace App;

use App\Notifications\EmailVerificationNotification;
use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Laravel\Passport\HasApiTokens;

class User extends Authenticatable
{
    use Notifiable, HasApiTokens;

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'name', 'email', 'password',
    ];

    /**
     * The attributes that should be hidden for arrays.
     *
     * @var array
     */
    protected $hidden = [
        'password', 'remember_token',
    ];

    /**
     * The attributes that should be cast to native types.
     *
     * @var array
     */
    protected $casts = [
        'email_verified_at' => 'datetime',
    ];

    public function admin(){

        return $this->hasMany(Admin::class);

    }

    public function elders(){

        return $this->hasMany(Elders::class);

    }

    public function deacons(){

        return $this->hasMany(Deacons::class);

    }

    public function members(){

        return $this->hasMany(Members::class);

    }

    public function EmailVerificationNotification()
    {
      $this->notify(new EmailVerificationNotification); // my notification
    }

}

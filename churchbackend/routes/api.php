<?php

use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/


Route::get('fetchChurchMembers', 'Api\MembersController@fetchChurchMembers');
Route::post('registerClergy', 'Api\Auth\Register@registerClergy');
Route::get('fetchMembersStatics', 'Api\MembersController@fetchMembersStatics' );

Route::middleware('auth:api')->group(function () {



});

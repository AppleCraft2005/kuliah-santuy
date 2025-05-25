<?php 
namespace App\Controllers;

use App\Controllers\BaseController;

class User extends BaseController {
    public function dashboard() {
        return view('dashboard_user_vw');
    }
}
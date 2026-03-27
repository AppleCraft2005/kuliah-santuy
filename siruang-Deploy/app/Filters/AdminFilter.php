<?php
namespace App\Filters;

use CodeIgniter\Filters\FilterInterface;
use CodeIgniter\HTTP\RequestInterface;

// class AdminFilter implements FilterInterface {
//     public function before(RequestInterface $request, $arguments = null){
//         if (session()->get('role') !== 'admin') {
//             return redirect()->to('/dashboard/user')->with('error','tidak bisa pindah ke admin!');
//         }
//     }
// }
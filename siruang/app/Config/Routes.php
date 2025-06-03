<?php

use CodeIgniter\Router\RouteCollection;

/**
 * @var RouteCollection $routes
 */
$routes->get('/', 'Home::index');
$routes->get('/peminjaman','Ruang::index');

$routes->get('/login', 'Authentication::login');
$routes->post('/login/auth', 'Authentication::loginauth');

$routes->get('/register', 'Authentication::register');
$routes->post('/register/auth', 'Authentication::registerauth');

$routes->get('/logout','Authentication::logout');

$routes->group('admin', ['filter' => 'auth'], function($routes) {
    $routes->get('dashboard', 'Admin\Dashboard::index');
    $routes->get('peminjaman','Admin\Peminjaman::index');
    $routes->get('peminjaman/edit/(:num)','Admin\Peminjaman::edit/$1');
    $routes->get('peminjaman/delete/(:num)', 'Admin\Peminjaman::delete/$1');
    $routes->post('peminjaman/save','Admin\Peminjaman::save');
});

$routes->group('user', ['filter' => 'auth'], function($routes) {
    $routes->get('dashboard', 'User\Dashboard::index');
    $routes->get('peminjaman','User\Peminjaman::index');
    $routes->get('peminjaman/edit/(:num)','User\Peminjaman::edit/$1');
    $routes->get('peminjaman/delete/(:num)', 'User\Peminjaman::delete/$1');
    $routes->post('peminjaman/save','User\Peminjaman::save');
});

// $routes->get('/dashboard/user', 'User\Dashboard::index', ['filter' => 'auth']);

$routes->get('/form','Form::index');

$routes->get('/tes', 'tes::index', ['filter' => 'auth']);
// $routes->get('/ruang', 'Home::listruang');

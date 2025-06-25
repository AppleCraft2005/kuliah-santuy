<?php

use CodeIgniter\Router\RouteCollection;

/**
 * @var RouteCollection $routes
 */
$routes->get('/', 'Home::index');
$routes->get('peminjaman','ListPeminjamanRuang::index', ['as' => 'peminjaman']);
$routes->get('fasilitas-ruangan', 'ListFasilitasRuangan::index', ['as' => 'fasilitas_ruangan']);

$routes->get('login', 'Authentication::login', ['as' => 'login']);
$routes->post('login', 'Authentication::loginauth', ['as' => 'login_auth']);

$routes->get('register', 'Authentication::register', ['as' => 'register']);
$routes->post('register', 'Authentication::registerauth', ['as' => 'register_auth']);

$routes->get('forgot-pwd', 'Authentication::forgotPwdForm', ['as' => 'forgot_password']);
$routes->post('forgot-pwd', 'Authentication::sendResetLink', ['as' => 'send_reset_link']);

$routes->get('reset-pwd', 'Authentication::resetPwdForm', ['as' => 'reset_password_form']);
$routes->post('reset-pwd', 'Authentication::updatePwd', ['as' => 'reset_password']);

$routes->get('logout','Authentication::logout');

$routes->group('admin', ['filter' => 'auth'], function($routes) {
    $routes->get('dashboard', 'Admin\Dashboard::index', ['as' => 'admin_dashboard']);
    $routes->get('peminjaman/edit/(:num)','Admin\Peminjaman::edit/$1', ['as' => 'admin_edit_peminjaman']);
    $routes->get('peminjaman/delete/(:num)', 'Admin\Peminjaman::delete/$1', ['as' => 'admin_delete_peminjaman']);
    $routes->post('peminjaman/save','Admin\Peminjaman::save', ['as' => 'admin_save_peminjaman']);
});

$routes->group('user', ['filter' => 'auth'], function($routes) {
    $routes->get('dashboard', 'User\Dashboard::index', ['as' => 'user_dashboard']);
    $routes->get('peminjaman','User\Peminjaman::index', ['as' => 'user_add_peminjaman']);
    $routes->get('peminjaman/edit/(:num)','User\Peminjaman::edit/$1', ['as' => 'user_edit_peminjaman']);
    $routes->get('peminjaman/delete/(:num)', 'User\Peminjaman::delete/$1', ['as' => 'user_delete_peminjaman']);
    $routes->post('peminjaman/save','User\Peminjaman::save', ['as' => 'user_save_peminjaman']);
});
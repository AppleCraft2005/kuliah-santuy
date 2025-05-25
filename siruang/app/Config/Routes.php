<?php

use CodeIgniter\Router\RouteCollection;

/**
 * @var RouteCollection $routes
 */
$routes->get('/', 'Ruang::index');

$routes->get('/login', 'Authentication::login');
$routes->post('/login/auth', 'Authentication::loginauth');

$routes->get('/register', 'Authentication::register');
$routes->post('/register/auth', 'Authentication::registerauth');

$routes->get('/logout','Authentication::logout');

$routes->get('/dashboard/admin', 'Admin::dashboard', ['filter' => 'auth']);
$routes->get('/dashboard/user', 'User::dashboard', ['filter' => 'auth']);

$routes->get('/tes', 'tes::index', ['filter' => 'auth']);
// $routes->get('/ruang', 'Home::listruang');

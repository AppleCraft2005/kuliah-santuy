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

$routes->get('/tes', 'tes::index');
// $routes->get('/ruang', 'Home::listruang');

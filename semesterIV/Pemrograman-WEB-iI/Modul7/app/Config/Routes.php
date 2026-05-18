<?php

use CodeIgniter\Router\RouteCollection;

/**
 * @var RouteCollection $routes
 */
// $routes->get('/', 'Home::index');

$routes->get('/', 'Login::index');
$routes->post('/login/proses', 'Login::Auth');

$routes->get('/buku','Buku::index');
$routes->get('/buku/tambah','Buku::tambah');
$routes->get('/buku/edit/(:num)','Buku::edit/$1');
$routes->get('/buku/hapus/(:num)','Buku::hapus/$1');
$routes->post('/buku/simpan','Buku::simpan');

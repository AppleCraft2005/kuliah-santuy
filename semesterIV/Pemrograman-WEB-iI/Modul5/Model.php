<?php 
require 'koneksi.php';

function getData($q) {
    global $koneksi;
    $result = mysqli_query($koneksi, $q);
    $rows = [];

    while($row = mysqli_fetch_assoc($result)) {
        $rows[] = $row;
    }

    return $rows;
}
function insertData($table, $data) {
    global $koneksi;

    unset($data['submit']);

    $columns = implode(", ", array_keys($data));
    $values = implode("', '", array_map('addslashes', array_values($data)));

    return mysqli_query($koneksi, "INSERT INTO $table ($columns) VALUES ('$values')");
}
function deleteData($table, $column, $data) {
    global $koneksi;

    return mysqli_query($koneksi, "DELETE FROM $table WHERE $column = $data");
}
function editData($table, $Column, $columnvalue, $data) {
    global $koneksi;

    unset($data['submit']);

    $updates = [];
    foreach($data as $column => $value) {
        $updates[] = "$column = '" . addslashes($value) . "'";
    }

    $updatestr = implode(", ", $updates);

    return mysqli_query($koneksi, "UPDATE $table SET $updatestr WHERE $Column = '$columnvalue'");

}
?>
<?php

namespace App\Controllers;

use App\Models\JadwalPerkuliahanModel;

class Home extends BaseController {
    protected $jadwalPerkuliahanModel;

    public function __construct() {
        $this->jadwalPerkuliahanModel = new  JadwalPerkuliahanModel();
    }

    public function index() {
        $waktuPerkuliahan = [
            '08:00-08:50', '08:50-09:40', 
            '09:40-10:30', '10:30-11:20', 
            '11:20-12:10', '12:10-13:00', 
            '13:00-13:50', '13:50-14:40', 
            '14:40-15:30', '15:30-16:20', 
            '16:20-17:10', '17:10-18:00'
        ];
        $hariPerkuliahan = ['Senin', 'Selasa', 'Rabu', 'Kamis', 'Jumat'];

        $getAllJadwal = $this->jadwalPerkuliahanModel->getJadwalBaseQuery()->findAll();
        $jadwalTersusun = [];
        foreach ($hariPerkuliahan as $hari) {
            foreach ($waktuPerkuliahan as $waktu) {
                $jadwalTersusun[$hari][$waktu] = [];
            }
        }

        // foreach ($getAllJadwal as $jadwal) {
        //     $jamMulaiFormatted = substr($jadwal['waktu_mulai'], 0, 5);
        //     $matchedSlot = null;
        //     foreach($waktuPerkuliahan as $waktu) {
        //         list($slotMulai, $slotSelesai) = explode('-', $waktu);
        //         if($jamMulaiFormatted == $slotMulai) {
        //             $matchedSlot = $waktu;
        //             break;
        //         }
        //     }
        //     if($matchedSlot && isset($jadwalTersusun[$jadwal['hari']][$matchedSlot])) {
        //         $jadwalTersusun[$jadwal['hari']][$matchedSlot][] = [
        //             'nama_matkul' => esc($jadwal['nama_matkul']),
        //             'nama_dosen' => esc($jadwal['nama_dosen']),
        //             'nama_ruang' => esc($jadwal['nama_ruang']),
        //         ];
        //     }
        // }

        foreach ($getAllJadwal as $jadwal) {
            $waktuMulaiFromDB = \DateTime::createFromFormat('H:i:s', $jadwal['waktu_mulai']);
            $waktuSelesaiFromDB = \DateTime::createFromFormat('H:i:s', $jadwal['waktu_selesai']);

            foreach($waktuPerkuliahan as $waktu) {
                list($waktuMulaiFromTH, $waktuSelesaiFromTH) = explode('-', $waktu);

                $waktuMulaiForTH = \DateTime::createFromFormat('H:i', $waktuMulaiFromTH);
                $waktuSelesaiForTH = \DateTime::createFromFormat('H:i', $waktuSelesaiFromTH);

                $isOverlap = $waktuMulaiFromDB < $waktuSelesaiForTH && $waktuSelesaiFromDB > $waktuMulaiForTH;
                if($isOverlap && isset($jadwalTersusun[$jadwal['nama_hari']][$waktu])) {
                    $jadwalTersusun[$jadwal['nama_hari']][$waktu][] = [
                        'nama_matkul' => esc($jadwal['nama_matkul']),
                        'nama_dosen' => esc($jadwal['nama_dosen']),
                        'nama_ruang' => esc($jadwal['nama_ruang']),
                    ];
                } 
            }
        }


        $data = [
            'hariPerkuliahan' => $hariPerkuliahan,
            'waktuPerkuliahan' => $waktuPerkuliahan,
            'jadwalTersusun' => $jadwalTersusun
        ];

        return view('Home_vw', $data);
    }
}
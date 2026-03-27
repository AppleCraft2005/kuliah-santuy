<?php

if (!function_exists('sendWhatsAppFonnte')) {
    function sendWhatsAppFonnte($phone, $message)
    {
        $token = env('FonnteAPI'); // API Key dari Fonnte

        $curl = curl_init();

        curl_setopt_array($curl, [
            CURLOPT_URL => "https://api.fonnte.com/send",
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_POST => true,
            CURLOPT_POSTFIELDS => [
                'target' => $phone,
                'message' => $message,
            ],
            CURLOPT_HTTPHEADER => [
                "Authorization: $token"
            ],
        ]);

        $response = curl_exec($curl);
        curl_close($curl);

        return $response;
    }
}

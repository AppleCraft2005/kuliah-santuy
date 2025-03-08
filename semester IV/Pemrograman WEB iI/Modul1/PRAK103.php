<?php 
    $Celcius = 37.841;
    $toFahrenheit = round((9/5) * $Celcius + 32, 4);
    $toKelvin = round($Celcius + 273.15, 4);
    $toReamur = round((4/5) * $Celcius, 4);

    echo "Fahrenheit (F) = $toFahrenheit <br>";
    echo "Reamur (R) = $toReamur <br>";
    echo "Kelvin (K) = $toKelvin";

?>
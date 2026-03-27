<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php foreach($tim as $t): ?>
        <p>nama saya <?= esc($t['nama']) ?> dan jabatan saya adalah <?= esc($t['posisi']); ?></p>
    <?php endforeach; ?>
</body>
</html>
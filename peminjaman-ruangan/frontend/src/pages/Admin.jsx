import { useEffect, useState } from 'react';

function Admin() {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch('http://localhost/backend/data_pinjam.php')
      .then(res => res.json())
      .then(data => setData(data));
  }, []);

  const handleKonfirmasi = async (id, status) => {
    const alasan = prompt("Masukkan alasan:");
    await fetch('http://localhost/backend/konfirmasi.php', {
      method: 'POST',
      body: JSON.stringify({ id, status, alasan }),
    });
    alert('Status diperbarui');
    window.location.reload();
  };

  return (
    <div className="p-4">
      <h1 className="text-xl font-bold mb-4">Panel Admin</h1>
      {data.map((d, i) => (
        <div key={i} className="border p-4 mb-2 rounded shadow">
          <p><strong>Ruang:</strong> {d.ruang}</p>
          <p><strong>Matkul:</strong> {d.nama_matkul}</p>
          <p><strong>Jam:</strong> {d.jam_mulai} - {d.jam_akhir}</p>
          <p><strong>Status:</strong> {d.status}</p>
          <button onClick={() => handleKonfirmasi(d.id, 'diterima')} className="bg-blue-500 text-white px-2 py-1 rounded mr-2">Terima</button>
          <button onClick={() => handleKonfirmasi(d.id, 'ditolak')} className="bg-red-500 text-white px-2 py-1 rounded">Tolak</button>
        </div>
      ))}
    </div>
  );
}

export default Admin;

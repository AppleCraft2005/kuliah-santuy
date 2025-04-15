import { useState } from 'react';

function FormPeminjaman() {
  const [form, setForm] = useState({
    ruang: '',
    nama_peminjam: localStorage.getItem('user') || '',
    nama_dosen: '',
    nama_matkul: '',
    jam_mulai: '',
    jam_akhir: '',
  });

  const handleChange = (e) => {
    setForm({...form, [e.target.name]: e.target.value});
  };

  const handleSubmit = async () => {
    const res = await fetch('http://localhost/backend/pinjam.php', {
      method: 'POST',
      body: JSON.stringify(form),
    });
    const data = await res.json();
    if (data.status === 'success') alert('Permintaan terkirim!');
  };

  const jamOptions = ['08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00'];

  return (
    <div className="p-4">
      <h1 className="text-xl font-bold mb-4">Form Peminjaman Ruangan</h1>
      <input name="ruang" placeholder="Nama Ruangan" className="border p-2 mb-2 w-full" onChange={handleChange} />
      <input name="nama_dosen" placeholder="Nama Dosen" className="border p-2 mb-2 w-full" onChange={handleChange} />
      <input name="nama_matkul" placeholder="Nama Matkul" className="border p-2 mb-2 w-full" onChange={handleChange} />

      <div className="mb-2">
        <label className="mr-2">Jam Mulai:</label>
        <select name="jam_mulai" className="border p-2" onChange={handleChange}>
          <option value="">Pilih</option>
          {jamOptions.map((j) => (
            <option key={j} value={j}>{j}</option>
          ))}
        </select>
      </div>

      <div className="mb-2">
        <label className="mr-2">Jam Akhir:</label>
        <select name="jam_akhir" className="border p-2" onChange={handleChange}>
          <option value="">Pilih</option>
          {jamOptions.map((j) => (
            <option key={j} value={j}>{j}</option>
          ))}
        </select>
      </div>

      <button onClick={handleSubmit} className="bg-green-500 text-white px-4 py-2 rounded">
        Submit
      </button>
    </div>
  );
}

export default FormPeminjaman;

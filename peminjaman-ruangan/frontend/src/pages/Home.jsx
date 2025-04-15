import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

function Home() {
  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    fetch('http://localhost/backend/rooms.php') // ganti dengan endpoint yang sesuai
      .then((res) => res.json())
      .then((data) => setRooms(data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className="p-6">
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-2xl font-bold">Daftar Ruangan</h1>
        <Link
          to="/login"
          className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
        >
          Login
        </Link>
      </div>

      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
        {rooms.map((room) => (
          <div key={room.id} className="p-4 bg-white rounded shadow">
            <h2 className="text-lg font-semibold">{room.nama_ruangan}</h2>
            <p
              className={
                room.status === 'kosong'
                  ? 'text-green-500'
                  : 'text-red-500'
              }
            >
              {room.status.toUpperCase()}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Home;

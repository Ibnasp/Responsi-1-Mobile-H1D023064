nama: Ibna Oktavia Saputri

NIM: H1D023064

shift baru: C

shift asal: F

Demo aplikasi:
[App Demo](preview/Responsi_1_Mobile.gif)
[Lihat video demo](preview/Responsi_1_Mobile.mp4)

Penjelasan Alur Data:
1.	Aplikasi memanggil API https://api.football-data.org/v4/teams/{id} menggunakan Retrofit.
  <br>Kemudian terdapat @GET("teams/{id}") yang artinya aplikasi akan mengambil data tim berdasarkan ID (ID = 89, yaitu RCD Mallorca).
2.	Token API dikirim lewat header X-Auth-Token. X-Auth-Token adalah kunci autentikasi dari Football-Data.org
3.	Response JSON dikonversi otomatis ke data class Kotlin (TeamResponse).
4.	Pada mainviewmodel.kt,  fetchTeam() memanggil getTeamData() dari ApiService.
Jika respons sukses, data JSON diubah menjadi objek TeamResponse menggunakan Gson converter. Objek ini disimpan ke _team (MutableLiveData). team (LiveData versi read-only) dipantau oleh setiap Activity agar otomatis update begitu data berubah.
5.	Begitu data team dari API berhasil diambil, setiap Activity yang mengamati vm.team akan otomatis menerima update. Tidak perlu memanggil ulang API di setiap halaman cukup observe() dan tampilkan data.
6.	Penyajian Data di UI (Binding ke Layout):
<br>Halaman Coach: menampilkan team.coach.name, team.coach.nationality dan dateOfBirth (dari API).
<br>Halaman Squad: menampilkan team.squad (dari API) melalui RecyclerView dan PlayerAdapter.
<br>Halaman History: menampilkan team.name + teks sejarah (statis dari kode).
<br>Data dari API langsung diikat (bind) ke komponen UI seperti TextView, ImageView, dan RecyclerView
7.	Hasil Akhir di Layar Saat aplikasi dijalankan:
MainActivity memanggil vm.fetchTeam() untuk mengambil data tim.
Retrofit mengirim request ke API → server Football-Data.org membalas JSON data klub, kemudian ViewModel memproses dan menyimpan hasilnya di LiveData dan semua Activity (Main, Coach, Squad, History) menerima update data lewat observe(). Hasilnya data tampil otomatis di layar: nama klub, pelatih, daftar pemain, dan lain-lain.


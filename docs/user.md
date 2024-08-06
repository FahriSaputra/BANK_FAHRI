# Expected
Terdapat fungsi untuk mendaftarkan nasabah baru dengan data yang dimasukkan
antara lain adalah nama lengkap, alamat, tempat lahir, tanggal lahir, nomor KTP, dan
nomor handphone
- Terdapat fungsi untuk mendapatkan data NASABAH dengan menggunakan nomor KTP
- Terdapat fungsi untuk melihat daftar SEMUA NASABAH yang sudah pernah terdaftar
  pada sistem
- Terdapat fungsi untuk pengkinian data NASABAH. Misalnya, mengubah alamat,
  mengubah nomor handphone.
- Terdapat fungsi untuk menghapus data NASABAH yang sudah terdaftar pada sistem.

# User API Spec

## Get All Nasabah

End Point : GET /api/users

Response Body :

```json
{
  "status": "success",
  "error": null,
  "data": [
    {
      "id_card": 3213216487327,
      "full_name": "Fahri Saputra",
      "address": "Pejompongan",
      "birth_place": "Jakarta",
      "birth_date": "321",
      "phone": "08961286732"
    }
  ]
}
```

## Get Nasabah

End Point : GET /api/users/{uuid}

Response Body :

```json
{
  "status": "success",
  "error": null,
  "data": {
    "id_card": 3213216487327,
    "full_name": "Fahri Saputra",
    "address": "Pejompongan",
    "birth_place": "Jakarta",
    "birth_date": "321",
    "phone": "08961286732"
  }
}
```



## Post Nasabah

End Point : POST /api/users

Request Body :

```json
{
  "data": {
    "id_card": 3213216487327,
    "full_name": "Fahri Saputra",
    "address": "Pejompongan",
    "birth_place": "Jakarta",
    "birth_date": "321",
    "phone": "08961286732"
  }
}
```

Response Body (Success) :

```json
{
  "status": "success",
  "error": null,
  "data": "success"
}
```

Response Body (Failed) :

```json
{
  "status": "error",
  "error": "error message",
  "data": null
}
```

## Put Nasabah

End Point : PATCH /api/users/{id_card}

Request Body :

```json
{
  "data": {
    "id_card": 3213216487327,
    "full_name": "Fahri Saputra",
    "address": "Pejompongan",
    "birth_place": "Jakarta",
    "birth_date": "321",
    "phone": "08961286732"
  }
}
```

Response Body (success) :

```json
{
  "status": "success",
  "error": null,
  "data": "success"
}
```

Response Body (Failed) :

```json
{
  "status": "error",
  "error": "error message",
  "data": null
}
```

## Delete Nasabah

End Point : DELETE /api/users/{id_card}

Response Body : 

```json 
{
  "status": "success",
  "error": "error message",
  "data": null
}
```

Response Body (Failed) :

```json
{
  "status": "error",
  "error": "error message",
  "data": null
}
```




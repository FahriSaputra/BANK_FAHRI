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

End Point : GET /api/v1/users

Response Body :

```json
{
  "status": 200,
  "message": "success",
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

End Point : GET /api/v1/users/{uuid}

Response Body :

```json
{
  "status": 200,
  "error": null,
  "message": "success",
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

Response Body (Not Found):

```json
{
  "status": 404,
  "error": "Not Found",
  "message": "User Not Found",
  "data": null
}
```

## Post Nasabah

End Point : POST /api/v1/users

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
  "status": 200,
  "error": null,
  "message": "success",
  "data": null,
}
```

## Patch Nasabah

End Point : PATCH /api/v1/users/{id_card}

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
  "data": null,
  "error": null,
  "status": 200,
  "message": "success"
}
```

Response Body (Failed) :

```json
{
  "data": null,
  "error": "error message",
  "status": 500,
  "message": "Internal Server Error"
}
```

## Delete Nasabah

End Point : DELETE /api/v1/users/{id_card}

Response Body : 

```json 
{
  "data": null,
  "error": null,
  "status": 200,
  "message": "success"
}
```

Response Body (Failed) :

```json
{
  "data": null,
  "error": "error message",
  "status": 500,
  "message": "Internal Server Error"
}
```




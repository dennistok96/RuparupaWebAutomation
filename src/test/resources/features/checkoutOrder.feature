Feature: verify checkout order functionality

  Background: User is logged in
    Given akses "https://www.ruparupa.com"

  Scenario: verify checkout order with invalid data
    When Klik Kategori Belanja lalu "Rumah Tangga"
    And Pilih berdasarkan Promo "Buy 1 Get 1"
    And Berdasarkan hasil tersebut pilih Urut Berdasarkan "Produk Terbaru"
    And Klik produk yang muncul pada baris pertama
    And Pada halaman produk, klik button Tambah ke keranjang
    And Klik button Lanjut ke Keranjang
    And Klik Sign In
    And Masukkan random email dan password
    Then Verify error login message

@Product
Feature: verify product functionality

  Background: User is logged in
    Given akses "https://www.ruparupa.com"

    @Smoke @Skip
  Scenario: successfully navigate to product category
    When Klik Kategori Belanja lalu "Rumah Tangga"
    Then Verify "Rumah Tangga" category label is displayed
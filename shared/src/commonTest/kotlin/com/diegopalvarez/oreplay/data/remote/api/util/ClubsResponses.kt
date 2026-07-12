package com.diegopalvarez.oreplay.data.remote.api.util

object ClubsResponses {
    // Valid Responses
    val valid = """
        {
          "data": [
            {
              "id": "0029c770-6bc5-4623-b8f1-ad806d9ca343",
              "short_name": "A Coruña ARTABROS"
            }
          ]
        }
    """.trimIndent()

    val valid_list = """
        {
          "data": [
            {
              "id": "0029c770-6bc5-4623-b8f1-ad806d9ca343",
              "short_name": "A Coruña ARTABROS"
            },
            {
              "id": "e560852f-ae5a-44a1-af94-8d49bb0c49ad",
              "short_name": "A Coruña BRIGANTIA"
            },
            {
              "id": "199ec8b6-da82-43d8-a1d3-e46c4de2b972",
              "short_name": "A Coruña COCO"
            },
            {
              "id": "388c7957-a1ca-4b88-9a4d-8e637373a54c",
              "short_name": "A Coruña LICEO"
            },
            {
              "id": "e6de46ce-006a-4ce5-a2f5-e4c54dc994e9",
              "short_name": "As Neves VIZHOJA-CORNELIOS"
            },
            {
              "id": "453494cb-f9de-482e-9833-9ed992d46a34",
              "short_name": "Barco de Valdeor OURO"
            },
            {
              "id": "066650ac-95b9-4369-8f51-f49979b23e53",
              "short_name": "Betanzos OP BETANZOS"
            },
            {
              "id": "c4db8701-ee79-4c57-ae5b-6e8387178559",
              "short_name": "Cádiz FUNDI-O"
            },
            {
              "id": "034a5575-ccd9-41d8-bffc-0f2bca8cd039",
              "short_name": "Culleredo GALLAECIA_RAID"
            },
            {
              "id": "9aa7f17b-44a5-40cd-810f-296cf9e768c2",
              "short_name": "Cuntis XESTEIRAS"
            },
            {
              "id": "e637b48a-ba4b-4c04-8c5d-b2ad7512678d",
              "short_name": "Ferrol MONTAÑA_FERROL"
            },
            {
              "id": "8adccfbf-28d2-402f-aa58-d0809a63fb24",
              "short_name": "Granada Veleta"
            },
            {
              "id": "24e8083c-41bc-4e3a-b46f-73709628d02a",
              "short_name": "LUGO COMPÁS"
            },
            {
              "id": "7c89805b-8687-4f7d-9d9b-23433c5d8bcf",
              "short_name": "LUGO FLUVIAL_LUGO"
            },
            {
              "id": "9443173a-49ae-4734-be48-e18179614778",
              "short_name": "Nigrán RAZA PALLEIRA"
            },
            {
              "id": "7ede2d6e-837d-4f9d-9d7f-e4ecf5353b2c",
              "short_name": "O Porriño BUDIÑORAID"
            },
            {
              "id": "9197dc3c-272b-4d61-9cf3-4e06719fb0df",
              "short_name": "Ordes SEO"
            },
            {
              "id": "535b143b-ad5f-4f31-bc83-24c5885e63cf",
              "short_name": "Pontedeume MONTBREAMO"
            },
            {
              "id": "528545c2-9f12-4bdb-8e9c-c5d189694a05",
              "short_name": "Pontevedra AROMON"
            },
            {
              "id": "3fd8e5b5-0754-4a75-a58e-94f71d780658",
              "short_name": "Porto do Son ADC_ARNELA"
            },
            {
              "id": "b6bed069-9bc4-4a2e-99c6-fc2aa6b5fb82",
              "short_name": "Santiago de Comp USC"
            },
            {
              "id": "1bd9cf9b-fb9d-443d-bd2a-e4490e6a5972",
              "short_name": "Sevilla ADOL"
            },
            {
              "id": "7760df1c-4e2f-4433-8717-81358d7342d6",
              "short_name": "Vigo U-VIGO"
            },
            {
              "id": "d17aa342-0704-4d5e-b4a9-c83ee4f9f9ce",
              "short_name": "Xinzo de Limia LIMIACTIVA"
            }
          ]
        }
    """.trimIndent()

    val empty = """
        {
          "data": []
        }
    """.trimIndent()

    // Error Responses
    val noResponse = ""

    val incompleteResponse = """
        {
          "data": [
            {
              "id": "0029c770-6bc5-4623-b8f1-ad806d9ca343",
            }
          ]
        }
    """.trimIndent()
}
package com.diegopalvarez.oreplay.data.remote.api.util

object ClassesResponses {
    // Valid Responses
    val valid = """
        {
          "data": [
            {
              "id": "45fb60e7-958c-4e12-8a03-6614530211e7",
              "short_name": "F-12",
              "long_name": "Feminino 12",
              "splits": []
            }
          ]
        }
    """.trimIndent()

    val valid_list = """
        {
          "data": [
            {
              "id": "45fb60e7-958c-4e12-8a03-6614530211e7",
              "short_name": "F-12",
              "long_name": "Feminino 12",
              "splits": []
            },
            {
              "id": "1cc8fe3e-753d-456d-9d6b-9876502801ad",
              "short_name": "F-14",
              "long_name": "Feminino 14",
              "splits": []
            },
            {
              "id": "f53e0c72-cbb8-4acc-a1e6-ae8a1754d80f",
              "short_name": "F-16",
              "long_name": "Feminino 16",
              "splits": []
            },
            {
              "id": "ff225131-e930-4415-b859-08abf2305681",
              "short_name": "F-18",
              "long_name": "Feminino 18",
              "splits": []
            },
            {
              "id": "0722bd3d-4bde-4af7-af5e-37aacdd92eab",
              "short_name": "F-21",
              "long_name": "Feminino 21",
              "splits": []
            },
            {
              "id": "bd6984a0-a8e2-45fc-8def-371e1c7dc9e5",
              "short_name": "F-35",
              "long_name": "Feminino 35",
              "splits": []
            },
            {
              "id": "5d98e821-180d-4fc2-a088-64e6db5a3201",
              "short_name": "F-45",
              "long_name": "Feminino 45",
              "splits": []
            },
            {
              "id": "cd60809a-6f3d-42b2-9419-e89100499618",
              "short_name": "F-Senior",
              "long_name": "Feminino Senior",
              "splits": []
            },
            {
              "id": "13b09754-a20f-44bb-8cb0-ce507c5f8f34",
              "short_name": "M-12",
              "long_name": "Masculino 12",
              "splits": []
            },
            {
              "id": "61f2d781-5d33-46a0-b45a-b7ef50909a02",
              "short_name": "M-14",
              "long_name": "Masculino 14",
              "splits": []
            },
            {
              "id": "ec795b93-ea77-4c5d-9967-4eae356ee32f",
              "short_name": "M-16",
              "long_name": "Masculino 16",
              "splits": []
            },
            {
              "id": "dcdd7547-290d-4d2b-ac42-4308135fe495",
              "short_name": "M-18",
              "long_name": "Masculino 18",
              "splits": []
            },
            {
              "id": "c08f0db7-f3cf-4c07-a1ec-24a6fa6e3e79",
              "short_name": "M-21",
              "long_name": "Masculino 21",
              "splits": []
            },
            {
              "id": "e34f9eb0-e380-4009-aaaa-99bb056c2ae4",
              "short_name": "M-35",
              "long_name": "Masculino 35",
              "splits": []
            },
            {
              "id": "c9eaa676-a8d0-4196-9896-b843457f63b7",
              "short_name": "M-45",
              "long_name": "Masculino 45",
              "splits": []
            },
            {
              "id": "d8f5c4ae-f70e-47b1-992a-bd69592ddc3c",
              "short_name": "Senior",
              "long_name": "Masculino Senior",
              "splits": []
            },
            {
              "id": "7d68270e-cd98-43aa-9843-183346dc6008",
              "short_name": "INI-C",
              "long_name": "Iniciación Curta",
              "splits": []
            },
            {
              "id": "29d52e04-abcd-4e39-b1e4-21838ee28caa",
              "short_name": "INI-L",
              "long_name": "Iniciación Longa",
              "splits": []
            },
            {
              "id": "34ce0f5b-ff39-4bee-a77d-1ab6297a5357",
              "short_name": "M-55",
              "long_name": "Masculino 55",
              "splits": []
            },
            {
              "id": "d1c237ba-f1d2-4724-bb72-76e81de1291c",
              "short_name": "F-55",
              "long_name": "Feminino 55",
              "splits": []
            },
            {
              "id": "47be83e3-2926-4b4e-bacb-56d07769ed05",
              "short_name": "M-55 NC",
              "long_name": "Masculino 55 NC",
              "splits": []
            },
            {
              "id": "8e3a2657-51b1-47b9-9796-5ff4392d0912",
              "short_name": "M-65",
              "long_name": "Masculino 65",
              "splits": []
            },
            {
              "id": "db4daf67-813d-48c4-a996-49fca38b89e8",
              "short_name": "F-65",
              "long_name": "Feminino 65",
              "splits": []
            },
            {
              "id": "ebff8850-f126-4663-b4a7-fde4efc1c62c",
              "short_name": "M-65 NC",
              "long_name": "Masculino 65 NC",
              "splits": []
            },
            {
              "id": "71437697-f6cf-4f90-ab25-fafe81d128b6",
              "short_name": "F-65 NC",
              "long_name": "Feminino 65 NC",
              "splits": []
            },
            {
              "id": "ef72a180-9347-4d5a-8d36-e3c9d084d284",
              "short_name": "M-45 NC",
              "long_name": "Masculino 45 NC",
              "splits": []
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
              "id": "45fb60e7-958c-4e12-8a03-6614530211e7",
              "short_name": "F-12",
              "long_name": "Feminino 12",
            }
          ]
        }
    """.trimIndent()
}
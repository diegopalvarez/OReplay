package com.diegopalvarez.oreplay.data.remote.api.util

object EventsResponses {
    // Valid Responses
    val valid = """
        {
          "data": [
            {
              "id": "4ebb0458-1268-42f7-b608-c1c385ae575c",
              "is_hidden": false,
              "description": "6ª LIGA SPRINT FEMADO",
              "picture": null,
              "website": "https://femado.org/",
              "scope": "r.h",
              "location": null,
              "country_code": "ES",
              "initial_date": "2026-06-14",
              "final_date": "2026-06-14",
              "timezone": "Europe/Madrid",
              "federation_id": null,
              "created": "2026-06-11T10:24:32.150+00:00",
              "modified": "2026-06-11T10:38:50.750+00:00",
              "organizer_id": "d5db45c7-dfb6-41ce-9818-086067dfb33b",
              "organizer": {
                "id": "d5db45c7-dfb6-41ce-9818-086067dfb33b",
                "name": "FEMADO",
                "country": "Spain",
                "region": "Comunidad de Madrid"
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/4ebb0458-1268-42f7-b608-c1c385ae575c"
                }
              }
            }
          ],
          "total": 1,
          "limit": 10,
          "_links": {
            "self": {
              "href": "https://www.oreplay.es/api/v1/events?page=1"
            }
          }
        }
    """.trimIndent()

    val valid_list = """
        {
          "data": [
            {
              "id": "2d823ca1-a946-4ae4-8746-7adbdb70223d",
              "is_hidden": false,
              "description": "Velingrad Cup 2026",
              "picture": null,
              "website": null,
              "scope": "nat",
              "location": null,
              "country_code": "BG",
              "initial_date": "2026-07-08",
              "final_date": "2026-07-09",
              "timezone": "Europe/Sofia",
              "federation_id": null,
              "created": "2026-07-08T10:34:01.476+00:00",
              "modified": "2026-07-08T10:39:39.356+00:00",
              "organizer_id": "c21b63ef-0856-479d-bb75-94c599ead0e3",
              "organizer": {
                "id": "c21b63ef-0856-479d-bb75-94c599ead0e3",
                "name": "MilMar",
                "country": "Bulgaria?",
                "region": null
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/2d823ca1-a946-4ae4-8746-7adbdb70223d"
                }
              }
            },
            {
              "id": "21046c51-bf38-40ab-8b12-f6ee27e7f0fe",
              "is_hidden": false,
              "description": "MTBO - Бодлите на розите 2026",
              "picture": null,
              "website": null,
              "scope": "nat",
              "location": null,
              "country_code": "BG",
              "initial_date": "2026-07-04",
              "final_date": "2026-07-05",
              "timezone": "Europe/Sofia",
              "federation_id": null,
              "created": "2026-07-03T18:22:17.095+00:00",
              "modified": "2026-07-04T06:54:10.789+00:00",
              "organizer_id": "c21b63ef-0856-479d-bb75-94c599ead0e3",
              "organizer": {
                "id": "c21b63ef-0856-479d-bb75-94c599ead0e3",
                "name": "MilMar",
                "country": "Bulgaria?",
                "region": null
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/21046c51-bf38-40ab-8b12-f6ee27e7f0fe"
                }
              }
            },
            {
              "id": "62a8addc-469f-4304-a217-4cc94c4d7ff2",
              "is_hidden": false,
              "description": "2026 Ranking FEGADO O-Pe",
              "picture": null,
              "website": "https://fegado.es/events/2026/",
              "scope": "r.h",
              "location": null,
              "country_code": "ES",
              "initial_date": "2026-06-28",
              "final_date": "2026-06-28",
              "timezone": "Europe/Madrid",
              "federation_id": null,
              "created": "2026-03-28T12:27:09.682+00:00",
              "modified": "2026-06-28T10:52:34.335+00:00",
              "organizer_id": "673fd719-f007-4d95-831c-655a45c1d4a5",
              "organizer": {
                "id": "673fd719-f007-4d95-831c-655a45c1d4a5",
                "name": "FEGADO",
                "country": "Spain",
                "region": "Galicia"
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/62a8addc-469f-4304-a217-4cc94c4d7ff2"
                }
              }
            },
            {
              "id": "3bf2e545-056c-4e74-bcff-58f9534a2525",
              "is_hidden": false,
              "description": "VI Orientación nocturna Villa de Carcabuey",
              "picture": null,
              "website": null,
              "scope": "loc",
              "location": null,
              "country_code": "ES",
              "initial_date": "2026-06-27",
              "final_date": "2026-06-27",
              "timezone": "Europe/Madrid",
              "federation_id": null,
              "created": "2026-06-18T15:46:53.710+00:00",
              "modified": "2026-06-18T15:49:06.850+00:00",
              "organizer_id": "601dc036-bb1b-4425-9c03-19ad1e67e8f0",
              "organizer": {
                "id": "601dc036-bb1b-4425-9c03-19ad1e67e8f0",
                "name": "VELETA",
                "country": "Spain",
                "region": "Andalucía"
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/3bf2e545-056c-4e74-bcff-58f9534a2525"
                }
              }
            },
            {
              "id": "44cda382-cb49-496e-9d79-3035066adfd6",
              "is_hidden": false,
              "description": "13°CPO Torrox",
              "picture": null,
              "website": null,
              "scope": "r.l",
              "location": null,
              "country_code": "ES",
              "initial_date": "2026-06-27",
              "final_date": "2026-06-27",
              "timezone": "Europe/Madrid",
              "federation_id": null,
              "created": "2026-06-27T14:36:10.653+00:00",
              "modified": "2026-06-27T14:38:30.691+00:00",
              "organizer_id": "c71eee29-b847-405a-ae34-129e1496458c",
              "organizer": {
                "id": "c71eee29-b847-405a-ae34-129e1496458c",
                "name": "COMA",
                "country": "Spain",
                "region": "Andalucía"
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/44cda382-cb49-496e-9d79-3035066adfd6"
                }
              }
            },
            {
              "id": "70366547-ee34-4b76-9a64-ff66ca9cd977",
              "is_hidden": false,
              "description": "Trofeo Concello de O Grove",
              "picture": null,
              "website": "https://fegado.es/events/view/i140g1ltxp6n/",
              "scope": "r.h",
              "location": null,
              "country_code": "ES",
              "initial_date": "2026-06-27",
              "final_date": "2026-06-28",
              "timezone": "Europe/Madrid",
              "federation_id": null,
              "created": "2026-06-26T19:52:23.118+00:00",
              "modified": "2026-06-26T19:58:29.735+00:00",
              "organizer_id": "72943f5d-2232-4dc2-852d-84a856c1f6b2",
              "organizer": {
                "id": "72943f5d-2232-4dc2-852d-84a856c1f6b2",
                "name": "AROMON",
                "country": "Spain",
                "region": "Galicia"
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977"
                }
              }
            },
            {
              "id": "152aac91-e74c-43e1-a66d-96ce7734e2b7",
              "is_hidden": false,
              "description": "CESA 2026",
              "picture": null,
              "website": "https://fexo.org/cesa-2026-2/",
              "scope": "nat",
              "location": null,
              "country_code": "ES",
              "initial_date": "2026-06-20",
              "final_date": "2026-06-22",
              "timezone": "Europe/Madrid",
              "federation_id": null,
              "created": "2026-05-25T11:42:46.468+00:00",
              "modified": "2026-06-17T20:08:58.802+00:00",
              "organizer_id": "7f8d17a0-0f34-421d-bb5e-c298d9484fce",
              "organizer": {
                "id": "7f8d17a0-0f34-421d-bb5e-c298d9484fce",
                "name": "FEXO",
                "country": "Spain",
                "region": "Extremadura"
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7"
                }
              }
            },
            {
              "id": "c49fbcbb-c9d9-4612-95c0-d55afca012a0",
              "is_hidden": false,
              "description": "SCORE NOCTURNO MEMBRILLA. CIRCUITO CIUDAD REAL",
              "picture": null,
              "website": null,
              "scope": "r.l",
              "location": null,
              "country_code": "ES",
              "initial_date": "2026-06-20",
              "final_date": "2026-06-20",
              "timezone": "Europe/Madrid",
              "federation_id": null,
              "created": "2026-06-19T22:14:51.987+00:00",
              "modified": "2026-06-19T22:18:26.592+00:00",
              "organizer_id": "03d7addf-a129-4353-8a9d-a08d9d70b0a2",
              "organizer": {
                "id": "03d7addf-a129-4353-8a9d-a08d9d70b0a2",
                "name": "MANZANARES-O",
                "country": "Spain",
                "region": "Castilla-La Mancha"
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/c49fbcbb-c9d9-4612-95c0-d55afca012a0"
                }
              }
            },
            {
              "id": "cae3562d-7eed-4603-ace1-1b27d3ea7fca",
              "is_hidden": false,
              "description": "купа Варненско лято 2026",
              "picture": null,
              "website": null,
              "scope": "nat",
              "location": null,
              "country_code": "BG",
              "initial_date": "2026-06-20",
              "final_date": "2026-06-21",
              "timezone": "Europe/Sofia",
              "federation_id": null,
              "created": "2026-06-17T06:34:49.627+00:00",
              "modified": "2026-06-17T06:37:22.210+00:00",
              "organizer_id": "c21b63ef-0856-479d-bb75-94c599ead0e3",
              "organizer": {
                "id": "c21b63ef-0856-479d-bb75-94c599ead0e3",
                "name": "MilMar",
                "country": "Bulgaria?",
                "region": null
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/cae3562d-7eed-4603-ace1-1b27d3ea7fca"
                }
              }
            },
            {
              "id": "4ebb0458-1268-42f7-b608-c1c385ae575c",
              "is_hidden": false,
              "description": "6ª LIGA SPRINT FEMADO",
              "picture": null,
              "website": "https://femado.org/",
              "scope": "r.h",
              "location": null,
              "country_code": "ES",
              "initial_date": "2026-06-14",
              "final_date": "2026-06-14",
              "timezone": "Europe/Madrid",
              "federation_id": null,
              "created": "2026-06-11T10:24:32.150+00:00",
              "modified": "2026-06-11T10:38:50.750+00:00",
              "organizer_id": "d5db45c7-dfb6-41ce-9818-086067dfb33b",
              "organizer": {
                "id": "d5db45c7-dfb6-41ce-9818-086067dfb33b",
                "name": "FEMADO",
                "country": "Spain",
                "region": "Comunidad de Madrid"
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/4ebb0458-1268-42f7-b608-c1c385ae575c"
                }
              }
            }
          ],
          "total": 251,
          "limit": 10,
          "_links": {
            "self": {
              "href": "https://www.oreplay.es/api/v1/events?page=1"
            },
            "next": {
              "href": "https://www.oreplay.es/api/v1/events?page=2"
            }
          }
        }
    """.trimIndent()

    val empty = """
        {
          "data": [],
          "total": 251,
          "limit": 10,
          "_links": {
            "self": {
              "href": "https://www.oreplay.es/api/v1/events?page=251"
            },
            "prev": {
              "href": "https://www.oreplay.es/api/v1/events?page=250"
            }
          }
        }
    """.trimIndent()

    // Error Responses
    val noResponse = ""

    val incompleteResponse = """
        {
          "data": [
            {
              "id": "2d823ca1-a946-4ae4-8746-7adbdb70223d",
              "is_hidden": false,
              "description": "Velingrad Cup 2026",
              "picture": null,
              "website": null,
              "scope": "nat",
              "location": null,
              "country_code": "BG",
              "initial_date": "2026-07-08",
              "final_date": "2026-07-09",
              "timezone": "Europe/Sofia",
              "federation_id": null,
              "created": "2026-07-08T10:34:01.476+00:00",
              "modified": "2026-07-08T10:39:39.356+00:00",
              "organizer_id": "c21b63ef-0856-479d-bb75-94c599ead0e3",
              "organizer": {
                "id": "c21b63ef-0856-479d-bb75-94c599ead0e3",
                "name": "MilMar",
                "country": "Bulgaria?",
                "region": null
              },
              "_links": {
                "self": {
                  "href": "https://www.oreplay.es/api/v1/events/2d823ca1-a946-4ae4-8746-7adbdb70223d"
                }
              }
            }
          ]
        }
    """.trimIndent()
}
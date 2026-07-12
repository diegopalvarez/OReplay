package com.diegopalvarez.oreplay.data.remote.api.util

object StagesResponses {
    // Valid Responses
    val valid = """
        {
          "data": {
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
            "stages": [
              {
                "id": "86e6b0da-dc15-4211-9825-a72e190138f3",
                "description": "Media",
                "start": "2026-06-26T22:00:00.000+00:00",
                "stage_type": {
                  "id": "29d5050b-4769-4be5-ace4-7e5973f68e3c",
                  "description": "Classic"
                },
                "last_logs": [
                  {
                    "state": 2,
                    "created": "2026-06-30T08:56:52.000+00:00"
                  },
                  {
                    "state": 0,
                    "created": "2026-06-30T08:52:47.000+00:00"
                  }
                ],
                "_links": {
                  "self": {
                    "href": "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3"
                  },
                  "results": {
                    "href": "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3/results/"
                  },
                  "classes": {
                    "href": "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3/classes/"
                  }
                }
              }
            ],
            "organizer": {
              "id": "72943f5d-2232-4dc2-852d-84a856c1f6b2",
              "name": "AROMON",
              "country": "Spain",
              "region": "Galicia"
            },
            "federation": null,
            "_links": {
              "self": {
                "href": "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977"
              }
            }
          }
        }
    """.trimIndent()

    val valid_list = """
        {
          "data": {
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
            "stages": [
              {
                "id": "1f930d0b-1215-4a5a-8f20-ae65339a09db",
                "description": "Larga Distancia",
                "start": "2026-06-20T06:00:00.000+00:00",
                "stage_type": {
                  "id": "cf89c9f2-4046-4e4b-a903-feb6bb279516",
                  "description": "One Man Relay"
                },
                "last_logs": [
                  {
                    "state": 1,
                    "created": "2026-06-20T06:00:28.000+00:00"
                  },
                  {
                    "state": 2,
                    "created": "2026-06-20T09:33:38.000+00:00"
                  }
                ],
                "_links": {
                  "self": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/1f930d0b-1215-4a5a-8f20-ae65339a09db"
                  },
                  "results": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/1f930d0b-1215-4a5a-8f20-ae65339a09db/results/"
                  },
                  "classes": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/1f930d0b-1215-4a5a-8f20-ae65339a09db/classes/"
                  }
                }
              },
              {
                "id": "5b4b9874-925b-48cf-a2c1-b08c9eb6601c",
                "description": "Laberintos - Clasificatoria",
                "start": "2026-06-20T18:00:00.000+00:00",
                "stage_type": {
                  "id": "29d5050b-4769-4be5-ace4-7e5973f68e3c",
                  "description": "Classic"
                },
                "last_logs": [
                  {
                    "state": 2,
                    "created": "2026-06-20T18:27:20.000+00:00"
                  }
                ],
                "_links": {
                  "self": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/5b4b9874-925b-48cf-a2c1-b08c9eb6601c"
                  },
                  "results": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/5b4b9874-925b-48cf-a2c1-b08c9eb6601c/results/"
                  },
                  "classes": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/5b4b9874-925b-48cf-a2c1-b08c9eb6601c/classes/"
                  }
                }
              },
              {
                "id": "c4fcb03d-4576-4d15-ac73-248bfbd90e5d",
                "description": "Laberintos - Final",
                "start": "2026-06-20T18:00:00.000+00:00",
                "stage_type": {
                  "id": "29d5050b-4769-4be5-ace4-7e5973f68e3c",
                  "description": "Classic"
                },
                "last_logs": [
                  {
                    "state": 2,
                    "created": "2026-06-20T18:42:16.000+00:00"
                  },
                  {
                    "state": 0,
                    "created": "2026-06-20T18:58:41.000+00:00"
                  }
                ],
                "_links": {
                  "self": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/c4fcb03d-4576-4d15-ac73-248bfbd90e5d"
                  },
                  "results": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/c4fcb03d-4576-4d15-ac73-248bfbd90e5d/results/"
                  },
                  "classes": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/c4fcb03d-4576-4d15-ac73-248bfbd90e5d/classes/"
                  }
                }
              },
              {
                "id": "3763ccaa-3304-408f-be4a-8090a567d053",
                "description": "Media Distancia",
                "start": "2026-06-21T06:00:00.000+00:00",
                "stage_type": {
                  "id": "cf89c9f2-4046-4e4b-a903-feb6bb279516",
                  "description": "One Man Relay"
                },
                "last_logs": [
                  {
                    "state": 1,
                    "created": "2026-06-21T06:05:41.000+00:00"
                  },
                  {
                    "state": 2,
                    "created": "2026-06-21T08:45:32.000+00:00"
                  }
                ],
                "_links": {
                  "self": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/3763ccaa-3304-408f-be4a-8090a567d053"
                  },
                  "results": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/3763ccaa-3304-408f-be4a-8090a567d053/results/"
                  },
                  "classes": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/3763ccaa-3304-408f-be4a-8090a567d053/classes/"
                  }
                }
              },
              {
                "id": "69ffb41f-cc9b-4a2a-b46a-b9c694485c31",
                "description": "Sprint",
                "start": "2026-06-21T18:00:00.000+00:00",
                "stage_type": {
                  "id": "29d5050b-4769-4be5-ace4-7e5973f68e3c",
                  "description": "Classic"
                },
                "last_logs": [
                  {
                    "state": 1,
                    "created": "2026-06-21T17:52:53.000+00:00"
                  },
                  {
                    "state": 2,
                    "created": "2026-06-21T19:59:14.000+00:00"
                  }
                ],
                "_links": {
                  "self": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/69ffb41f-cc9b-4a2a-b46a-b9c694485c31"
                  },
                  "results": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/69ffb41f-cc9b-4a2a-b46a-b9c694485c31/results/"
                  },
                  "classes": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/69ffb41f-cc9b-4a2a-b46a-b9c694485c31/classes/"
                  }
                }
              },
              {
                "id": "402f1c15-5aeb-4178-b230-0fb2f3163605",
                "description": "Relevos Mixtos",
                "start": "2026-06-22T07:30:00.000+00:00",
                "stage_type": {
                  "id": "9a918410-6dda-4c58-bec9-23839b336e59",
                  "description": "Relay"
                },
                "last_logs": [
                  {
                    "state": 1,
                    "created": "2026-06-22T07:08:16.000+00:00"
                  },
                  {
                    "state": 2,
                    "created": "2026-06-22T09:13:42.000+00:00"
                  },
                  {
                    "state": 0,
                    "created": "2026-06-22T09:10:04.000+00:00"
                  }
                ],
                "_links": {
                  "self": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/402f1c15-5aeb-4178-b230-0fb2f3163605"
                  },
                  "results": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/402f1c15-5aeb-4178-b230-0fb2f3163605/results/"
                  },
                  "classes": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/402f1c15-5aeb-4178-b230-0fb2f3163605/classes/"
                  }
                }
              },
              {
                "id": "5c30bcac-7fff-4f2d-a06e-c4c7c5c5e275",
                "description": "",
                "start": null,
                "stage_type": {
                  "id": "3d4cf037-64d6-442c-969d-35452048daf9",
                  "description": "Overall"
                },
                "last_logs": [
                  {
                    "state": 2,
                    "created": "2026-06-20T18:59:17.000+00:00"
                  }
                ],
                "_links": {
                  "self": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/5c30bcac-7fff-4f2d-a06e-c4c7c5c5e275"
                  },
                  "results": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/5c30bcac-7fff-4f2d-a06e-c4c7c5c5e275/results/"
                  },
                  "classes": {
                    "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7/stages/5c30bcac-7fff-4f2d-a06e-c4c7c5c5e275/classes/"
                  }
                }
              }
            ],
            "organizer": {
              "id": "7f8d17a0-0f34-421d-bb5e-c298d9484fce",
              "name": "FEXO",
              "country": "Spain",
              "region": "Extremadura"
            },
            "federation": null,
            "_links": {
              "self": {
                "href": "https://www.oreplay.es/api/v1/events/152aac91-e74c-43e1-a66d-96ce7734e2b7"
              }
            }
          }
        }
    """.trimIndent()

    val empty = """
        {
          "data": {
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
            "stages": [],
            "organizer": {
              "id": "72943f5d-2232-4dc2-852d-84a856c1f6b2",
              "name": "AROMON",
              "country": "Spain",
              "region": "Galicia"
            },
            "federation": null,
            "_links": {
              "self": {
                "href": "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977"
              }
            }
          }
        }
    """.trimIndent()

    // Error Responses
    val noResponse = ""

    val incompleteResponse = """
        {
          "data": {
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
            "federation": null,
            "_links": {
              "self": {
                "href": "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977"
              }
            }
          }
        }
    """.trimIndent()
}
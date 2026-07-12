package com.diegopalvarez.oreplay.data.remote.api.util

object ResultsResponses {
    // Valid Responses
    val valid_splits = """
        {
          "data": [
            {
              "id": "00924a47-1a21-4c9d-b3e2-ae78bf20009a",
              "bib_number": "4354",
              "is_nc": false,
              "eligibility": null,
              "sicard": "8027206",
              "sex": "F",
              "leg_number": 1,
              "created": "2026-06-30T08:55:55.493+00:00",
              "class": {
                "id": "1cc8fe3e-753d-456d-9d6b-9876502801ad",
                "short_name": "F-14",
                "long_name": "Feminino 14"
              },
              "club": {
                "id": "034a5575-ccd9-41d8-bffc-0f2bca8cd039",
                "short_name": "Culleredo GALLAECIA_RAID"
              },
              "full_name": "Noa Albarran Oroza",
              "stage": {
                "id": "9a343741-7709-4833-897d-d5cea274e943",
                "result_type_id": "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                "start_time": "2026-06-27T09:09:00.000+00:00",
                "finish_time": "2026-06-27T09:45:45.000+00:00",
                "upload_type": "res_splits",
                "time_seconds": 2205,
                "position": 2,
                "status_code": "0",
                "is_nc": false,
                "contributory": true,
                "time_behind": 130,
                "time_neutralization": 0,
                "time_adjusted": 0,
                "time_penalty": 0,
                "time_bonus": 0,
                "points_final": "0.0000",
                "points_behind": "0.0000",
                "points_adjusted": "0.0000",
                "points_penalty": "0.0000",
                "points_bonus": "0.0000",
                "note": null,
                "leg_number": 1,
                "created": "2026-06-30T08:55:55.504+00:00",
                "splits": [
                  {
                    "id": "97051a45-3c81-4d1a-93b3-9c76eb41208c",
                    "is_intermediate": false,
                    "reading_time": "2026-06-27T09:45:25.000+00:00",
                    "points": 0,
                    "order_number": 16,
                    "created": "2026-06-30T08:55:55.688+00:00",
                    "control": {
                      "id": "f24410e3-aebd-4c7f-8e94-2cae79a2068e",
                      "station": "100",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  }
                ]
              },
              "overalls": null
            }
          ]
        }
    """.trimIndent()

    val valid_overall ="""
      {
        "data": [
          {
            "id": "086910d3-4ac4-4f0b-9097-43dbc34d529c",
            "bib_number": "4404",
            "is_nc": false,
            "eligibility": null,
            "sicard": "8027203",
            "sex": "M",
            "leg_number": 1,
            "created": "2026-04-01T07:22:28.833+00:00",
            "class": {
              "id": "4e4bf06f-8dbb-4bf0-ba99-3f705aaa0d82",
              "short_name": "M-55",
              "long_name": "Masculino 55"
            },
            "club": {
              "id": "9e11d2d2-c1c4-428f-a871-7c78b842c438",
              "short_name": "Culleredo GALLAECIA_RAID"
            },
            "full_name": "Rodrigo González Romano",
            "stage": null,
            "overalls": {
              "parts": [
                {
                  "id": "026bdcd4-18f6-46aa-ba0d-b9ffc9b9dca1",
                  "stage_order": 1,
                  "upload_type": "total_points",
                  "stage": {
                    "id": "bbdc0398-3ced-4054-bc80-7e77b957805c",
                    "description": "01 Paderne"
                  },
                  "position": 1,
                  "status_code": "0",
                  "is_nc": false,
                  "contributory": true,
                  "time_seconds": 0,
                  "time_behind": 0,
                  "points_final": 100,
                  "points_behind": null,
                  "note": null
                }
              ],
              "overall": {
                "id": "",
                "stage_order": 1,
                "upload_type": "ranking_computed",
                "stage": null,
                "position": 1,
                "status_code": "0",
                "is_nc": null,
                "contributory": null,
                "time_seconds": 0,
                "time_behind": null,
                "points_final": 300,
                "points_behind": null,
                "note": null
              }
            }
          }
        ]
      }
    """.trimIndent()


    val valid_team = """
      {
        "data": [
          {
            "id": "036c3d5e-a47d-413e-ac16-7b03d88e5171",
            "bib_number": "310",
            "is_nc": false,
            "eligibility": null,
            "legs": null,
            "created": "2026-06-22T09:13:09.560+00:00",
            "runners": [
              {
                "id": "6739ae46-4fc3-4249-888a-0a4cfcd61ead",
                "bib_number": null,
                "is_nc": false,
                "eligibility": null,
                "sicard": "8539568",
                "sex": "F",
                "leg_number": 1,
                "created": "2026-06-22T09:13:09.601+00:00",
                "class": null,
                "club": {
                  "id": "f193c600-c5e7-483b-ab76-dbc5380f1ad3",
                  "short_name": "COMUNITAT VALENCIANA"
                },
                "full_name": "Victoria Mena Haro",
                "stage": {
                  "id": "eea8aefa-417e-4e3b-9405-e2ea4069a394",
                  "result_type_id": "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                  "start_time": "2026-06-22T07:27:00.000+00:00",
                  "finish_time": "2026-06-22T07:42:21.000+00:00",
                  "upload_type": "res_splits",
                  "time_seconds": 921,
                  "position": 11,
                  "status_code": "0",
                  "is_nc": false,
                  "contributory": false,
                  "time_behind": 0,
                  "time_neutralization": 0,
                  "time_adjusted": 0,
                  "time_penalty": 0,
                  "time_bonus": 0,
                  "points_final": "0.0000",
                  "points_behind": "0.0000",
                  "points_adjusted": "0.0000",
                  "points_penalty": "0.0000",
                  "points_bonus": "0.0000",
                  "note": null,
                  "leg_number": 1,
                  "created": "2026-06-22T09:13:09.609+00:00",
                  "splits": [
                    {
                      "id": "2693bd26-8495-4cd6-b6cc-780f58fdf99d",
                      "is_intermediate": false,
                      "reading_time": "2026-06-22T07:41:51.000+00:00",
                      "points": 0,
                      "order_number": 15,
                      "created": "2026-06-22T09:13:09.793+00:00",
                      "control": {
                        "id": "3e94fe42-4a6f-406d-8d70-472595ac3fc2",
                        "station": "200",
                        "control_type": {
                          "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                          "description": "Normal Control"
                        }
                      }
                    }
                  ]
                },
                "overalls": null
              }
            ],
            "class": {
              "id": "0a09691b-bd02-4adc-988b-9f1a39649ddd",
              "short_name": "JUVENIL",
              "long_name": "JUVENIL"
            },
            "club": {
              "id": "f193c600-c5e7-483b-ab76-dbc5380f1ad3",
              "short_name": "COMUNITAT VALENCIANA"
            },
            "full_name": "COMUNITAT VALENCIANA B",
            "stage": {
              "id": "f8e64472-09f8-478c-8e8d-0b022789404e",
              "result_type_id": "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
              "start_time": "2026-06-22T07:27:00.000+00:00",
              "finish_time": "2026-06-22T08:33:49.000+00:00",
              "upload_type": "res_splits",
              "time_seconds": 4009,
              "position": 0,
              "status_code": "9",
              "is_nc": false,
              "contributory": null,
              "time_behind": 1028,
              "time_neutralization": 0,
              "time_adjusted": 0,
              "time_penalty": 0,
              "time_bonus": 0,
              "points_final": "0.0000",
              "points_adjusted": "0.0000",
              "points_penalty": "0.0000",
              "points_bonus": "0.0000",
              "leg_number": 4,
              "note": null,
              "created": "2026-06-22T09:13:09.594+00:00",
              "splits": []
            },
            "overalls": null
          }
        ]
      }
    """.trimIndent()

    val valid_list_overalls = """
      {
        "data": [
          {
            "id": "0e960ebb-a29b-4fb2-8d1d-140081c86a96",
            "bib_number": "4731",
            "is_nc": false,
            "eligibility": null,
            "sicard": "2057735",
            "sex": "F",
            "leg_number": 1,
            "created": "2026-04-01T07:22:30.638+00:00",
            "class": {
              "id": "71ddd5a4-8c57-41af-8b86-1b4adbf74d63",
              "short_name": "F-12",
              "long_name": "Feminino 12"
            },
            "club": {
              "id": "d860aedd-c41e-41a0-8950-964d79a1f093",
              "short_name": "Nigrán RAZA PALLEIRA"
            },
            "full_name": "Noa Rodríguez Seijo",
            "stage": null,
            "overalls": {
              "parts": [
                {
                  "id": "83c14187-df44-4fe1-9985-eff5a6f66219",
                  "stage_order": 1,
                  "upload_type": "total_points",
                  "stage": {
                    "id": "bbdc0398-3ced-4054-bc80-7e77b957805c",
                    "description": "01 Paderne"
                  },
                  "position": 1,
                  "status_code": "0",
                  "is_nc": false,
                  "contributory": true,
                  "time_seconds": 0,
                  "time_behind": 0,
                  "points_final": 100,
                  "points_behind": null,
                  "note": null
                },
                {
                  "id": "241665d8-c625-49e8-9c78-29eabc5ba087",
                  "stage_order": 2,
                  "upload_type": "total_points",
                  "stage": {
                    "id": "e655e86a-2cd1-458b-b5a8-5a8023bca910",
                    "description": "02 Abadin"
                  },
                  "position": 1,
                  "status_code": "0",
                  "is_nc": false,
                  "contributory": true,
                  "time_seconds": 0,
                  "time_behind": 0,
                  "points_final": 100,
                  "points_behind": null,
                  "note": null
                },
                {
                  "id": "6666020e-d3c1-4929-9262-f1fad63a5560",
                  "stage_order": 3,
                  "upload_type": "total_points",
                  "stage": {
                    "id": "963de8e8-dfc3-4c2e-8bdb-7544a371fd92",
                    "description": "03 Segade"
                  },
                  "position": 1,
                  "status_code": "0",
                  "is_nc": false,
                  "contributory": true,
                  "time_seconds": 0,
                  "time_behind": 0,
                  "points_final": 100,
                  "points_behind": null,
                  "note": null
                },
                {
                  "id": "939871be-162e-4360-897a-13e50ff05dc3",
                  "stage_order": 4,
                  "upload_type": "total_points",
                  "stage": {
                    "id": "7065d804-3adb-4f97-8231-6557e0a7d96d",
                    "description": "04 Oleiros"
                  },
                  "position": 2,
                  "status_code": "0",
                  "is_nc": false,
                  "contributory": false,
                  "time_seconds": 0,
                  "time_behind": 0,
                  "points_final": 97,
                  "points_behind": null,
                  "note": null
                },
                {
                  "id": "6a0bd4f5-da86-4399-bf49-63d5150d52f5",
                  "stage_order": 5,
                  "upload_type": "total_points",
                  "stage": {
                    "id": "f7cb5ea4-1ae0-4579-af3f-c3dc9bf9ea0f",
                    "description": "05 O Grove"
                  },
                  "position": 1,
                  "status_code": "0",
                  "is_nc": false,
                  "contributory": false,
                  "time_seconds": 0,
                  "time_behind": 0,
                  "points_final": 100,
                  "points_behind": null,
                  "note": null
                }
              ],
              "overall": {
                "id": "",
                "stage_order": 1,
                "upload_type": "ranking_computed",
                "stage": null,
                "position": 2,
                "status_code": "0",
                "is_nc": null,
                "contributory": null,
                "time_seconds": 0,
                "time_behind": null,
                "points_final": 300,
                "points_behind": null,
                "note": null
              }
            }
          }
        ]
      }
    """.trimIndent()

    val valid_list_team = """
      {
        "data": [
            {
          "id": "0de38fb0-91b4-4b02-82c6-255f055d929f",
          "bib_number": "306",
          "is_nc": false,
          "eligibility": null,
          "legs": null,
          "created": "2026-06-22T09:13:23.043+00:00",
          "runners": [
            {
              "id": "d758998a-a0fc-4edb-b5d0-b1dbb9ff00bf",
              "bib_number": null,
              "is_nc": false,
              "eligibility": null,
              "sicard": "8542606",
              "sex": "F",
              "leg_number": 1,
              "created": "2026-06-22T09:13:23.076+00:00",
              "class": null,
              "club": {
                "id": "3668f6ac-5cc5-4f0e-a809-a1e4d3a2ce45",
                "short_name": "ASTURIAS"
              },
              "full_name": "Paula Klett Álvarez",
              "stage": {
                "id": "8c1b8634-b115-420b-a328-5ef87b6fa203",
                "result_type_id": "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                "start_time": "2026-06-22T07:27:00.000+00:00",
                "finish_time": "2026-06-22T07:41:54.000+00:00",
                "upload_type": "res_splits",
                "time_seconds": 894,
                "position": 9,
                "status_code": "0",
                "is_nc": false,
                "contributory": false,
                "time_behind": 0,
                "time_neutralization": 0,
                "time_adjusted": 0,
                "time_penalty": 0,
                "time_bonus": 0,
                "points_final": "0.0000",
                "points_behind": "0.0000",
                "points_adjusted": "0.0000",
                "points_penalty": "0.0000",
                "points_bonus": "0.0000",
                "note": null,
                "leg_number": 1,
                "created": "2026-06-22T09:13:23.083+00:00",
                "splits": [
                  {
                    "id": "4de5a99d-0eea-479d-b015-add1b3d91d72",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:41:23.000+00:00",
                    "points": 0,
                    "order_number": 15,
                    "created": "2026-06-22T09:13:23.210+00:00",
                    "control": {
                      "id": "3e94fe42-4a6f-406d-8d70-472595ac3fc2",
                      "station": "200",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "57dc1c96-0ffb-41c2-9720-ea00ce18cdd7",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:40:20.000+00:00",
                    "points": 0,
                    "order_number": 14,
                    "created": "2026-06-22T09:13:23.205+00:00",
                    "control": {
                      "id": "a0e62367-d9cf-4e23-b79c-09a9f91afccf",
                      "station": "69",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "6f921f4a-097b-480d-9a95-d352705d2977",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:39:53.000+00:00",
                    "points": 0,
                    "order_number": 13,
                    "created": "2026-06-22T09:13:23.196+00:00",
                    "control": {
                      "id": "c33fcc65-4723-4a2a-9d49-0a9d76a49b8e",
                      "station": "68",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "263504f1-bfc5-475d-b1fc-b2052149f1cb",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:39:03.000+00:00",
                    "points": 0,
                    "order_number": 12,
                    "created": "2026-06-22T09:13:23.186+00:00",
                    "control": {
                      "id": "28bf2d20-989d-40b0-bbcf-01b45595edb2",
                      "station": "41",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "52b2770c-c89b-4a72-bd59-356582f99b5a",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:37:42.000+00:00",
                    "points": 0,
                    "order_number": 11,
                    "created": "2026-06-22T09:13:23.178+00:00",
                    "control": {
                      "id": "4a940e88-c0b6-4758-b2aa-900fb8446cd0",
                      "station": "59",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "558f62c7-d35e-4bbc-9816-104d6c2a2341",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:37:14.000+00:00",
                    "points": 0,
                    "order_number": 10,
                    "created": "2026-06-22T09:13:23.170+00:00",
                    "control": {
                      "id": "43020912-dcb9-4d4a-a5e6-6e5c8167c8ee",
                      "station": "43",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "501b1f42-dc01-40a4-896b-9b90bc518086",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:36:15.000+00:00",
                    "points": 0,
                    "order_number": 9,
                    "created": "2026-06-22T09:13:23.142+00:00",
                    "control": {
                      "id": "a0b67b1e-49a5-4eaf-a9f7-f5027218be04",
                      "station": "40",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "02d25db6-8c08-4ef2-a60e-be9728347112",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:35:22.000+00:00",
                    "points": 0,
                    "order_number": 8,
                    "created": "2026-06-22T09:13:23.138+00:00",
                    "control": {
                      "id": "7f499c89-9e45-4b52-b468-cc15e9cd0714",
                      "station": "66",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "d8db2ea2-17fe-4379-b64e-a2ad2c894042",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:34:37.000+00:00",
                    "points": 0,
                    "order_number": 7,
                    "created": "2026-06-22T09:13:23.129+00:00",
                    "control": {
                      "id": "6b68c19f-3e70-465c-919a-7780b4b2fd79",
                      "station": "100",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "6a3955d1-56f9-444c-8ae6-a54704ad4fcd",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:34:14.000+00:00",
                    "points": 0,
                    "order_number": 6,
                    "created": "2026-06-22T09:13:23.125+00:00",
                    "control": {
                      "id": "f2f54fcf-9948-423a-b5ad-8ceaa4a37a0d",
                      "station": "39",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "6c93fd78-23bd-4a2e-983c-b3a60ecdd9b4",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:32:38.000+00:00",
                    "points": 0,
                    "order_number": 5,
                    "created": "2026-06-22T09:13:23.116+00:00",
                    "control": {
                      "id": "b14af3dd-d883-44b5-9189-8e073379fa5e",
                      "station": "50",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "d3d8bb2c-d4e2-4c19-9362-a718dc901349",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:31:59.000+00:00",
                    "points": 0,
                    "order_number": 4,
                    "created": "2026-06-22T09:13:23.108+00:00",
                    "control": {
                      "id": "a496bd4a-1eb7-49dc-b0c8-a23e2c566def",
                      "station": "58",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "26725166-7ad8-402a-86e2-42f1ae9792f7",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:31:31.000+00:00",
                    "points": 0,
                    "order_number": 3,
                    "created": "2026-06-22T09:13:23.100+00:00",
                    "control": {
                      "id": "64cf7875-84c1-46ee-acae-b66b655bcbcd",
                      "station": "57",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "14313332-11c9-4d61-bb54-f2942b190f2c",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:30:04.000+00:00",
                    "points": 0,
                    "order_number": 2,
                    "created": "2026-06-22T09:13:23.093+00:00",
                    "control": {
                      "id": "93ce64d6-fe65-4f30-9724-7dbacda6e116",
                      "station": "56",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "858eb831-e829-46cd-aa22-e8bd7ef151c3",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:29:02.000+00:00",
                    "points": 0,
                    "order_number": 1,
                    "created": "2026-06-22T09:13:23.085+00:00",
                    "control": {
                      "id": "c64198a9-bdca-4d6b-a774-0780a09a6d30",
                      "station": "54",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  }
                ]
              },
              "overalls": null
            },
            {
              "id": "150943cb-ffed-407f-9777-fbf6e416f2e0",
              "bib_number": null,
              "is_nc": false,
              "eligibility": null,
              "sicard": "8486076",
              "sex": "M",
              "leg_number": 2,
              "created": "2026-06-22T09:13:23.218+00:00",
              "class": null,
              "club": {
                "id": "3668f6ac-5cc5-4f0e-a809-a1e4d3a2ce45",
                "short_name": "ASTURIAS"
              },
              "full_name": "Ruben Lopez Rimada",
              "stage": {
                "id": "7480d60e-5909-4c73-a74f-27d2644929de",
                "result_type_id": "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                "start_time": "2026-06-22T07:41:54.000+00:00",
                "finish_time": "2026-06-22T07:55:58.000+00:00",
                "upload_type": "res_splits",
                "time_seconds": 843,
                "position": 13,
                "status_code": "0",
                "is_nc": false,
                "contributory": false,
                "time_behind": 0,
                "time_neutralization": 0,
                "time_adjusted": 0,
                "time_penalty": 0,
                "time_bonus": 0,
                "points_final": "0.0000",
                "points_behind": "0.0000",
                "points_adjusted": "0.0000",
                "points_penalty": "0.0000",
                "points_bonus": "0.0000",
                "note": null,
                "leg_number": 2,
                "created": "2026-06-22T09:13:23.224+00:00",
                "splits": [
                  {
                    "id": "7c4194f0-0789-4f44-81dd-d3859a31e0e2",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:55:16.000+00:00",
                    "points": 0,
                    "order_number": 17,
                    "created": "2026-06-22T09:13:23.397+00:00",
                    "control": {
                      "id": "3e94fe42-4a6f-406d-8d70-472595ac3fc2",
                      "station": "200",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "e0b92de8-6a20-4a44-bef9-b24e732ac51b",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:54:30.000+00:00",
                    "points": 0,
                    "order_number": 16,
                    "created": "2026-06-22T09:13:23.389+00:00",
                    "control": {
                      "id": "a0e62367-d9cf-4e23-b79c-09a9f91afccf",
                      "station": "69",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "0503fdc4-ceba-4ab7-b3b3-b4d840160bf5",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:54:16.000+00:00",
                    "points": 0,
                    "order_number": 15,
                    "created": "2026-06-22T09:13:23.380+00:00",
                    "control": {
                      "id": "c33fcc65-4723-4a2a-9d49-0a9d76a49b8e",
                      "station": "68",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "0c99e87f-2908-433f-8788-0b758f5e44f6",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:53:43.000+00:00",
                    "points": 0,
                    "order_number": 14,
                    "created": "2026-06-22T09:13:23.370+00:00",
                    "control": {
                      "id": "28bf2d20-989d-40b0-bbcf-01b45595edb2",
                      "station": "41",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "d3d601c2-4daf-4dec-bf36-87044f70ea17",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:52:54.000+00:00",
                    "points": 0,
                    "order_number": 13,
                    "created": "2026-06-22T09:13:23.360+00:00",
                    "control": {
                      "id": "4a940e88-c0b6-4758-b2aa-900fb8446cd0",
                      "station": "59",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "2350025f-8044-4cd0-8af5-8e0a770d14eb",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:52:36.000+00:00",
                    "points": 0,
                    "order_number": 12,
                    "created": "2026-06-22T09:13:23.352+00:00",
                    "control": {
                      "id": "43020912-dcb9-4d4a-a5e6-6e5c8167c8ee",
                      "station": "43",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "b7a00252-8247-42d9-b1c9-c5d2940559c8",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:51:25.000+00:00",
                    "points": 0,
                    "order_number": 11,
                    "created": "2026-06-22T09:13:23.343+00:00",
                    "control": {
                      "id": "a0b67b1e-49a5-4eaf-a9f7-f5027218be04",
                      "station": "40",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "ed6f24dc-70ab-4317-b33f-ac9800c83480",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:50:19.000+00:00",
                    "points": 0,
                    "order_number": 10,
                    "created": "2026-06-22T09:13:23.328+00:00",
                    "control": {
                      "id": "2d5d7175-2a15-40af-8163-1e31b19307ce",
                      "station": "67",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "8d7556e3-c675-47a5-9f41-ebcda6bf0792",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:49:31.000+00:00",
                    "points": 0,
                    "order_number": 9,
                    "created": "2026-06-22T09:13:23.316+00:00",
                    "control": {
                      "id": "6b68c19f-3e70-465c-919a-7780b4b2fd79",
                      "station": "100",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "9d5e0007-765c-479e-84c6-707275495549",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:49:13.000+00:00",
                    "points": 0,
                    "order_number": 8,
                    "created": "2026-06-22T09:13:23.304+00:00",
                    "control": {
                      "id": "f2f54fcf-9948-423a-b5ad-8ceaa4a37a0d",
                      "station": "39",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "c31af81c-0542-4417-85ca-2de045599f89",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:48:29.000+00:00",
                    "points": 0,
                    "order_number": 7,
                    "created": "2026-06-22T09:13:23.296+00:00",
                    "control": {
                      "id": "e5c21cf6-0bbf-44eb-95b8-e8c3496cb3dd",
                      "station": "49",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "752b7e79-56e6-47bf-9d8a-89fd730e369a",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:47:59.000+00:00",
                    "points": 0,
                    "order_number": 6,
                    "created": "2026-06-22T09:13:23.286+00:00",
                    "control": {
                      "id": "5c55e3f1-a96c-464e-ab7d-8accf3aaf998",
                      "station": "65",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "c6d50698-c09a-45da-bfc8-4179467f39ad",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:47:30.000+00:00",
                    "points": 0,
                    "order_number": 5,
                    "created": "2026-06-22T09:13:23.276+00:00",
                    "control": {
                      "id": "588c9933-e441-4ab6-93b0-fad7429e9c83",
                      "station": "63",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "3128f5c1-65d8-43eb-8da3-b2efc8cf9c4d",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:46:53.000+00:00",
                    "points": 0,
                    "order_number": 4,
                    "created": "2026-06-22T09:13:23.269+00:00",
                    "control": {
                      "id": "a496bd4a-1eb7-49dc-b0c8-a23e2c566def",
                      "station": "58",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "34523df9-0bf5-4f34-badd-61720f2723be",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:46:36.000+00:00",
                    "points": 0,
                    "order_number": 3,
                    "created": "2026-06-22T09:13:23.250+00:00",
                    "control": {
                      "id": "64cf7875-84c1-46ee-acae-b66b655bcbcd",
                      "station": "57",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "478fc1a0-186d-4479-b2c3-06fd03262b16",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:45:52.000+00:00",
                    "points": 0,
                    "order_number": 2,
                    "created": "2026-06-22T09:13:23.243+00:00",
                    "control": {
                      "id": "93ce64d6-fe65-4f30-9724-7dbacda6e116",
                      "station": "56",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "670e3058-32f2-4c1c-84f8-85dc62e21f77",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:45:19.000+00:00",
                    "points": 0,
                    "order_number": 1,
                    "created": "2026-06-22T09:13:23.231+00:00",
                    "control": {
                      "id": "c64198a9-bdca-4d6b-a774-0780a09a6d30",
                      "station": "54",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  }
                ]
              },
              "overalls": null
            },
            {
              "id": "a55b8440-6e11-4f87-ac87-1de662961e53",
              "bib_number": null,
              "is_nc": false,
              "eligibility": null,
              "sicard": "8486066",
              "sex": "M",
              "leg_number": 3,
              "created": "2026-06-22T09:13:23.405+00:00",
              "class": null,
              "club": {
                "id": "3668f6ac-5cc5-4f0e-a809-a1e4d3a2ce45",
                "short_name": "ASTURIAS"
              },
              "full_name": "Elier Zarabozo Fernández",
              "stage": {
                "id": "ba3d3e21-24ba-49e5-8aab-be9a42e65581",
                "result_type_id": "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                "start_time": "2026-06-22T07:55:58.000+00:00",
                "finish_time": "2026-06-22T08:15:22.000+00:00",
                "upload_type": "res_splits",
                "time_seconds": 1164,
                "position": 20,
                "status_code": "0",
                "is_nc": false,
                "contributory": false,
                "time_behind": 0,
                "time_neutralization": 0,
                "time_adjusted": 0,
                "time_penalty": 0,
                "time_bonus": 0,
                "points_final": "0.0000",
                "points_behind": "0.0000",
                "points_adjusted": "0.0000",
                "points_penalty": "0.0000",
                "points_bonus": "0.0000",
                "note": null,
                "leg_number": 3,
                "created": "2026-06-22T09:13:23.413+00:00",
                "splits": [
                  {
                    "id": "38e95e44-621a-4d0b-a046-55cb6755e515",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:14:33.000+00:00",
                    "points": 0,
                    "order_number": 17,
                    "created": "2026-06-22T09:13:23.554+00:00",
                    "control": {
                      "id": "3e94fe42-4a6f-406d-8d70-472595ac3fc2",
                      "station": "200",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "3de5b975-28dc-41f4-a94d-f0f4c2dfc934",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:13:41.000+00:00",
                    "points": 0,
                    "order_number": 16,
                    "created": "2026-06-22T09:13:23.546+00:00",
                    "control": {
                      "id": "a0e62367-d9cf-4e23-b79c-09a9f91afccf",
                      "station": "69",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "b02a70c8-a292-42be-b0e4-1bc1f1b25dd8",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:13:10.000+00:00",
                    "points": 0,
                    "order_number": 15,
                    "created": "2026-06-22T09:13:23.537+00:00",
                    "control": {
                      "id": "c33fcc65-4723-4a2a-9d49-0a9d76a49b8e",
                      "station": "68",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "dc9817bc-889b-465e-be82-1986b7b4a70e",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:12:16.000+00:00",
                    "points": 0,
                    "order_number": 14,
                    "created": "2026-06-22T09:13:23.530+00:00",
                    "control": {
                      "id": "28bf2d20-989d-40b0-bbcf-01b45595edb2",
                      "station": "41",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "e8bcf7ca-9d0e-40f5-9f09-85b7240b784a",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:11:14.000+00:00",
                    "points": 0,
                    "order_number": 13,
                    "created": "2026-06-22T09:13:23.521+00:00",
                    "control": {
                      "id": "4a940e88-c0b6-4758-b2aa-900fb8446cd0",
                      "station": "59",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "b9b08538-5003-4da7-a962-9724e262be64",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:10:53.000+00:00",
                    "points": 0,
                    "order_number": 12,
                    "created": "2026-06-22T09:13:23.517+00:00",
                    "control": {
                      "id": "43020912-dcb9-4d4a-a5e6-6e5c8167c8ee",
                      "station": "43",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "1e8f51b9-d395-47c0-b13b-af1ab6fec1e7",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:09:16.000+00:00",
                    "points": 0,
                    "order_number": 11,
                    "created": "2026-06-22T09:13:23.505+00:00",
                    "control": {
                      "id": "ee4e007c-7077-4b56-a615-ae44d89b05f0",
                      "station": "53",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "d13cd22f-be9f-4724-a51c-01b405b19c0a",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:08:48.000+00:00",
                    "points": 0,
                    "order_number": 10,
                    "created": "2026-06-22T09:13:23.501+00:00",
                    "control": {
                      "id": "2d5d7175-2a15-40af-8163-1e31b19307ce",
                      "station": "67",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "3458c844-997b-47bf-a8c6-516d30969027",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:07:44.000+00:00",
                    "points": 0,
                    "order_number": 9,
                    "created": "2026-06-22T09:13:23.494+00:00",
                    "control": {
                      "id": "6b68c19f-3e70-465c-919a-7780b4b2fd79",
                      "station": "100",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "b1ee743b-280d-4c46-b1ad-2830d581668d",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:07:22.000+00:00",
                    "points": 0,
                    "order_number": 8,
                    "created": "2026-06-22T09:13:23.484+00:00",
                    "control": {
                      "id": "f2f54fcf-9948-423a-b5ad-8ceaa4a37a0d",
                      "station": "39",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "05c27ab0-4fa7-4646-b6bf-1220550eb637",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:06:30.000+00:00",
                    "points": 0,
                    "order_number": 7,
                    "created": "2026-06-22T09:13:23.474+00:00",
                    "control": {
                      "id": "e5c21cf6-0bbf-44eb-95b8-e8c3496cb3dd",
                      "station": "49",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "49b226e4-8622-4632-a574-09df95c25f4c",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:04:51.000+00:00",
                    "points": 0,
                    "order_number": 6,
                    "created": "2026-06-22T09:13:23.466+00:00",
                    "control": {
                      "id": "dc88f11c-be86-4f5e-aeac-b11d2cf05441",
                      "station": "64",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "ce44b575-0099-4d35-b425-4214ba6eb400",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:04:28.000+00:00",
                    "points": 0,
                    "order_number": 5,
                    "created": "2026-06-22T09:13:23.458+00:00",
                    "control": {
                      "id": "588c9933-e441-4ab6-93b0-fad7429e9c83",
                      "station": "63",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "0d22901d-7193-40fa-ac64-47a199e1cb39",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:59:51.000+00:00",
                    "points": 0,
                    "order_number": 4,
                    "created": "2026-06-22T09:13:23.445+00:00",
                    "control": {
                      "id": "a496bd4a-1eb7-49dc-b0c8-a23e2c566def",
                      "station": "58",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "2651b51e-bc5e-466e-8fd6-f6daa88a8e27",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:59:28.000+00:00",
                    "points": 0,
                    "order_number": 3,
                    "created": "2026-06-22T09:13:23.435+00:00",
                    "control": {
                      "id": "64cf7875-84c1-46ee-acae-b66b655bcbcd",
                      "station": "57",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "acff820e-38d8-493e-9316-1e5666215896",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:58:22.000+00:00",
                    "points": 0,
                    "order_number": 2,
                    "created": "2026-06-22T09:13:23.424+00:00",
                    "control": {
                      "id": "93ce64d6-fe65-4f30-9724-7dbacda6e116",
                      "station": "56",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "32d6d7b5-bb89-4b36-b541-e0ae3111d5e1",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T07:57:34.000+00:00",
                    "points": 0,
                    "order_number": 1,
                    "created": "2026-06-22T09:13:23.420+00:00",
                    "control": {
                      "id": "7dc57def-7d69-44ce-8867-23fe3356858b",
                      "station": "55",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  }
                ]
              },
              "overalls": null
            },
            {
              "id": "7709ae5f-60e4-4c2a-86bf-fa00b4a3ea70",
              "bib_number": null,
              "is_nc": false,
              "eligibility": null,
              "sicard": "8542610",
              "sex": "F",
              "leg_number": 4,
              "created": "2026-06-22T09:13:23.565+00:00",
              "class": null,
              "club": {
                "id": "3668f6ac-5cc5-4f0e-a809-a1e4d3a2ce45",
                "short_name": "ASTURIAS"
              },
              "full_name": "Marta Klett Álvarez",
              "stage": {
                "id": "12ce4f5a-fc91-4713-ab3e-2ee507ecc580",
                "result_type_id": "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                "start_time": "2026-06-22T08:15:22.000+00:00",
                "finish_time": "2026-06-22T08:36:36.000+00:00",
                "upload_type": "res_splits",
                "time_seconds": 1273,
                "position": 18,
                "status_code": "0",
                "is_nc": false,
                "contributory": false,
                "time_behind": 0,
                "time_neutralization": 0,
                "time_adjusted": 0,
                "time_penalty": 0,
                "time_bonus": 0,
                "points_final": "0.0000",
                "points_behind": "0.0000",
                "points_adjusted": "0.0000",
                "points_penalty": "0.0000",
                "points_bonus": "0.0000",
                "note": null,
                "leg_number": 4,
                "created": "2026-06-22T09:13:23.573+00:00",
                "splits": [
                  {
                    "id": "19582209-a6b3-4167-a75b-e8963d0234d7",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:36:09.000+00:00",
                    "points": 0,
                    "order_number": 15,
                    "created": "2026-06-22T09:13:23.727+00:00",
                    "control": {
                      "id": "3e94fe42-4a6f-406d-8d70-472595ac3fc2",
                      "station": "200",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "793b7500-f549-4991-a1a5-505391d978f7",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:35:06.000+00:00",
                    "points": 0,
                    "order_number": 14,
                    "created": "2026-06-22T09:13:23.718+00:00",
                    "control": {
                      "id": "a0e62367-d9cf-4e23-b79c-09a9f91afccf",
                      "station": "69",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "d557a9cf-fb36-459e-ac69-93897d520eb7",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:34:42.000+00:00",
                    "points": 0,
                    "order_number": 13,
                    "created": "2026-06-22T09:13:23.708+00:00",
                    "control": {
                      "id": "c33fcc65-4723-4a2a-9d49-0a9d76a49b8e",
                      "station": "68",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "41bd2f27-6bc8-4dbd-8318-a6274b832d6a",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:33:48.000+00:00",
                    "points": 0,
                    "order_number": 12,
                    "created": "2026-06-22T09:13:23.702+00:00",
                    "control": {
                      "id": "28bf2d20-989d-40b0-bbcf-01b45595edb2",
                      "station": "41",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "a84fee01-6089-4700-ad75-a73d2224ff04",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:32:29.000+00:00",
                    "points": 0,
                    "order_number": 11,
                    "created": "2026-06-22T09:13:23.688+00:00",
                    "control": {
                      "id": "4a940e88-c0b6-4758-b2aa-900fb8446cd0",
                      "station": "59",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "38bdd4cb-b4ff-4ff6-a85a-688828c5deb9",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:32:00.000+00:00",
                    "points": 0,
                    "order_number": 10,
                    "created": "2026-06-22T09:13:23.679+00:00",
                    "control": {
                      "id": "43020912-dcb9-4d4a-a5e6-6e5c8167c8ee",
                      "station": "43",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "bcbb625d-a3a0-45dd-9379-fdc47d7ee9a3",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:30:01.000+00:00",
                    "points": 0,
                    "order_number": 9,
                    "created": "2026-06-22T09:13:23.668+00:00",
                    "control": {
                      "id": "ee4e007c-7077-4b56-a615-ae44d89b05f0",
                      "station": "53",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "fe031f67-e48f-4a11-9208-70e9a43c7385",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:27:00.000+00:00",
                    "points": 0,
                    "order_number": 8,
                    "created": "2026-06-22T09:13:23.657+00:00",
                    "control": {
                      "id": "7f499c89-9e45-4b52-b468-cc15e9cd0714",
                      "station": "66",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "2a5cbf0c-ce44-4518-92bd-a9f886b0cf70",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:26:10.000+00:00",
                    "points": 0,
                    "order_number": 7,
                    "created": "2026-06-22T09:13:23.648+00:00",
                    "control": {
                      "id": "6b68c19f-3e70-465c-919a-7780b4b2fd79",
                      "station": "100",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "f145e138-4ba5-4aa6-aba5-95dcb7bc2a95",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:25:49.000+00:00",
                    "points": 0,
                    "order_number": 6,
                    "created": "2026-06-22T09:13:23.640+00:00",
                    "control": {
                      "id": "f2f54fcf-9948-423a-b5ad-8ceaa4a37a0d",
                      "station": "39",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "84af0829-d9d3-4935-a396-d5e6d2ae324c",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:24:32.000+00:00",
                    "points": 0,
                    "order_number": 5,
                    "created": "2026-06-22T09:13:23.633+00:00",
                    "control": {
                      "id": "2f1c8a5d-0083-4e51-b913-812b3d96f760",
                      "station": "51",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "a4f7d289-9164-49fd-b198-f60d37ed918f",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:23:31.000+00:00",
                    "points": 0,
                    "order_number": 4,
                    "created": "2026-06-22T09:13:23.626+00:00",
                    "control": {
                      "id": "a496bd4a-1eb7-49dc-b0c8-a23e2c566def",
                      "station": "58",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "37fa4ac7-203b-4c6a-8f54-911289c137b7",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:23:03.000+00:00",
                    "points": 0,
                    "order_number": 3,
                    "created": "2026-06-22T09:13:23.613+00:00",
                    "control": {
                      "id": "64cf7875-84c1-46ee-acae-b66b655bcbcd",
                      "station": "57",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "1d721a14-4bb2-4999-b7b3-83bf00bd90a8",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:21:41.000+00:00",
                    "points": 0,
                    "order_number": 2,
                    "created": "2026-06-22T09:13:23.603+00:00",
                    "control": {
                      "id": "93ce64d6-fe65-4f30-9724-7dbacda6e116",
                      "station": "56",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  },
                  {
                    "id": "32be9928-30e7-44c9-9c45-0d56d1354e26",
                    "is_intermediate": false,
                    "reading_time": "2026-06-22T08:20:18.000+00:00",
                    "points": 0,
                    "order_number": 1,
                    "created": "2026-06-22T09:13:23.580+00:00",
                    "control": {
                      "id": "7dc57def-7d69-44ce-8867-23fe3356858b",
                      "station": "55",
                      "control_type": {
                        "id": "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        "description": "Normal Control"
                      }
                    }
                  }
                ]
              },
              "overalls": null
            }
          ],
          "class": {
            "id": "0a09691b-bd02-4adc-988b-9f1a39649ddd",
            "short_name": "JUVENIL",
            "long_name": "JUVENIL"
          },
          "club": {
            "id": "3668f6ac-5cc5-4f0e-a809-a1e4d3a2ce45",
            "short_name": "ASTURIAS"
          },
          "full_name": "ASTURIAS A",
          "stage": {
            "id": "ee8d8122-8653-4c45-aeec-cbdb8b019e19",
            "result_type_id": "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
            "start_time": "2026-06-22T07:27:00.000+00:00",
            "finish_time": "2026-06-22T08:36:36.000+00:00",
            "upload_type": "res_splits",
            "time_seconds": 4176,
            "position": 0,
            "status_code": "9",
            "is_nc": false,
            "contributory": null,
            "time_behind": 1196,
            "time_neutralization": 0,
            "time_adjusted": 0,
            "time_penalty": 0,
            "time_bonus": 0,
            "points_final": "0.0000",
            "points_adjusted": "0.0000",
            "points_penalty": "0.0000",
            "points_bonus": "0.0000",
            "leg_number": 4,
            "note": null,
            "created": "2026-06-22T09:13:23.068+00:00",
            "splits": []
          },
          "overalls": null
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
              "id": "086910d3-4ac4-4f0b-9097-43dbc34d529c",
              "bib_number": "4404",
              "is_nc": false,
              "eligibility": null,
              "sicard": "8027203",
              "sex": "M",
              "leg_number": 1,
              "created": "2026-04-01T07:22:28.833+00:00",
              "class": {
                "id": "4e4bf06f-8dbb-4bf0-ba99-3f705aaa0d82",
                "short_name": "M-55",
                "long_name": "Masculino 55"
              },
              "club": {
                "id": "9e11d2d2-c1c4-428f-a871-7c78b842c438",
                "short_name": "Culleredo GALLAECIA_RAID"
              },
              "full_name": "Rodrigo González Romano",
            }
          ]
        }
    """.trimIndent()
}
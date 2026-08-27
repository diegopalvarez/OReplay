package com.diegopalvarez.oreplay.data.mappers.remote.objects

import com.diegopalvarez.oreplay.data.remote.dto.clubs.RemoteClub
import com.diegopalvarez.oreplay.data.remote.dto.results.ControlType
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteClassResults
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteControl
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteOverall
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteOverallResult
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResult
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResultsResponse
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteSplit
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteStageOveralls
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteStageResult

object RemoteResponse {
    val complete = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "02c0298a-d3e5-470e-8ae2-77a40063b407",
                bibNumber = "4346",
                isNc = false,
                eligibility = null,
                sicard = "2077088",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-06-30T08:53:10.392+00:00",
                runnerClass = RemoteClassResults(
                    id = "2c708bd2-cb93-4a56-a1ff-9471f1dfa590",
                    shortName = "F-21",
                    longName = "Feminino 21"
                ),
                runnerClub = RemoteClub(
                    id = "8aec7d3c-5e45-4a80-b459-93d7514d507c",
                    shortName = "Vigo U-VIGO"
                ),
                fullName = "Julia Pérez Álvarez",
                stageResult = RemoteStageResult(
                    id = "40062c79-1ccd-4c98-bfbe-a58ddd7f7096",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-28T09:13:00.000+00:00",
                    finishTime = "2026-06-28T09:51:03.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2283L,
                    position = 4L,
                    statusCode = "0",
                    isNc = false,
                    contributory = true,
                    timeBehind = 690L,
                    timeNeutralization = 0L,
                    timeAdjusted = 0L,
                    timePenalty = 0L,
                    timeBonus = 0L,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 1L,
                    created = "2026-06-30T08:53:10.402+00:00",
                    splits = listOf(
                        RemoteSplit(
                            id = "ea17d001-1dfc-4b6a-8c78-7eb2eb0d4096",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:50:53.000+00:00",
                            points = 0L,
                            orderNumber = 22L,
                            created = "2026-06-30T08:53:10.658+00:00",
                            control = RemoteControl(
                                id = "6c5c5f62-08ca-4834-8fc8-d7d75138c363",
                                station = "100",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "c8af39f9-c402-424a-a0fa-9d961f5ef635",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:50:11.000+00:00",
                            points = 0L,
                            orderNumber = 21L,
                            created = "2026-06-30T08:53:10.646+00:00",
                            control = RemoteControl(
                                id = "ea5e8c26-5a16-40ac-a7c9-8c1574c42bcd",
                                station = "75",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "541aa644-8dd1-42fd-a1fb-921c64335a1e",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:49:22.000+00:00",
                            points = 0L,
                            orderNumber = 20L,
                            created = "2026-06-30T08:53:10.636+00:00",
                            control = RemoteControl(
                                id = "157912be-832a-4d19-a804-074876dffdc3",
                                station = "57",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "cedd814e-7817-497e-a664-4b5e2c095aed",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:49:01.000+00:00",
                            points = 0L,
                            orderNumber = 19L,
                            created = "2026-06-30T08:53:10.627+00:00",
                            control = RemoteControl(
                                id = "865bcb3e-c783-438d-9ac9-216d7427e9ce",
                                station = "65",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "0002c0fd-5488-4917-9184-7fba2b8c65bd",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:45:51.000+00:00",
                            points = 0L,
                            orderNumber = 18L,
                            created = "2026-06-30T08:53:10.618+00:00",
                            control = RemoteControl(
                                id = "cacf4e42-e05e-456f-a9fe-0fa68cf06dcd",
                                station = "50",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "38ba786b-a63e-4e0d-bdea-98125ab17bd9",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:44:43.000+00:00",
                            points = 0L,
                            orderNumber = 17L,
                            created = "2026-06-30T08:53:10.595+00:00",
                            control = RemoteControl(
                                id = "3427e89d-d5b7-4c1f-b2d7-2bc0749df20a",
                                station = "53",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "f9f5a7d5-0aab-4ebe-a136-47f79ed9ca73",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:39:20.000+00:00",
                            points = 0L,
                            orderNumber = 16L,
                            created = "2026-06-30T08:53:10.566+00:00",
                            control = RemoteControl(
                                id = "42bc473d-396d-488e-b7fc-d265bc58b1f2",
                                station = "49",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "537c9ed4-6afa-4eb1-b7da-5d0dfa186164",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:37:08.000+00:00",
                            points = 0L,
                            orderNumber = 15L,
                            created = "2026-06-30T08:53:10.555+00:00",
                            control = RemoteControl(
                                id = "bded55d9-6d90-453f-9050-2e1e46b4fc00",
                                station = "41",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "7d695b2c-ac1f-4ac9-a120-e487b65ec464",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:33:06.000+00:00",
                            points = 0L,
                            orderNumber = 14L,
                            created = "2026-06-30T08:53:10.545+00:00",
                            control = RemoteControl(
                                id = "7ccf49e1-d48e-4c1c-95cd-f5989d6a9702",
                                station = "38",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "64297f00-9df1-4e43-97e0-9404d045a0cb",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:31:26.000+00:00",
                            points = 0L,
                            orderNumber = 13L,
                            created = "2026-06-30T08:53:10.536+00:00",
                            control = RemoteControl(
                                id = "80b7f349-1106-4f59-90bf-b8fd5f58933f",
                                station = "37",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "96823c33-381a-417f-b87d-8f3b5c33c3fc",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:29:35.000+00:00",
                            points = 0L,
                            orderNumber = 12L,
                            created = "2026-06-30T08:53:10.527+00:00",
                            control = RemoteControl(
                                id = "11cfdefb-efb7-483a-856c-91110689c19b",
                                station = "36",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "a1ed9aed-1410-4763-8169-405f6585d198",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:29:14.000+00:00",
                            points = 0L,
                            orderNumber = 11L,
                            created = "2026-06-30T08:53:10.516+00:00",
                            control = RemoteControl(
                                id = "8d07d63a-1153-49fd-8de9-c89a20fe0c9d",
                                station = "71",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "45837732-b902-40a9-8d07-55d47c309694",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:27:27.000+00:00",
                            points = 0L,
                            orderNumber = 10L,
                            created = "2026-06-30T08:53:10.508+00:00",
                            control = RemoteControl(
                                id = "699aef52-a2b7-4fb4-9851-c6dfcc39bb8b",
                                station = "47",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "1f8f4403-99a2-4d72-a3e6-16e63aaac8d5",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:26:49.000+00:00",
                            points = 0L,
                            orderNumber = 9L,
                            created = "2026-06-30T08:53:10.499+00:00",
                            control = RemoteControl(
                                id = "c0693939-3927-46d8-8567-ba2a334e0442",
                                station = "43",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "708f80e8-feba-4d0f-a8c4-7c353df55595",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:26:12.000+00:00",
                            points = 0L,
                            orderNumber = 8L,
                            created = "2026-06-30T08:53:10.491+00:00",
                            control = RemoteControl(
                                id = "60cf13fa-1edd-449d-9461-333720b9d141",
                                station = "59",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "91119fa0-7c1f-4275-9215-1bf49ae1bc8a",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:25:10.000+00:00",
                            points = 0L,
                            orderNumber = 7L,
                            created = "2026-06-30T08:53:10.486+00:00",
                            control = RemoteControl(
                                id = "1397180c-25e4-4cef-b504-0d6b0c5e9246",
                                station = "44",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "0401581a-c170-4b12-b03c-e6b6d502eb08",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:24:08.000+00:00",
                            points = 0L,
                            orderNumber = 6L,
                            created = "2026-06-30T08:53:10.477+00:00",
                            control = RemoteControl(
                                id = "41b69055-bc0c-4523-b54d-42dfd8be5fb2",
                                station = "77",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "5796d33b-ef8f-496c-b4e1-ce265b2c6483",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:18:58.000+00:00",
                            points = 0L,
                            orderNumber = 5L,
                            created = "2026-06-30T08:53:10.468+00:00",
                            control = RemoteControl(
                                id = "127239de-227d-4e20-b2ad-aeafa2f8bc5a",
                                station = "81",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "7a1db23a-a1f7-4a64-b2ad-d740af8cb795",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:18:21.000+00:00",
                            points = 0L,
                            orderNumber = 4L,
                            created = "2026-06-30T08:53:10.453+00:00",
                            control = RemoteControl(
                                id = "3d50f06c-35b7-48e6-945c-8fed925f0de6",
                                station = "82",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "ede6c7a8-953c-4653-afa2-f1a398f2b87d",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:15:23.000+00:00",
                            points = 0L,
                            orderNumber = 3L,
                            created = "2026-06-30T08:53:10.446+00:00",
                            control = RemoteControl(
                                id = "0088db1e-a2ab-40d8-ba68-68b922caf619",
                                station = "64",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "66368887-01dd-4bf2-b204-70ad3c3d1d0d",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:14:43.000+00:00",
                            points = 0L,
                            orderNumber = 2L,
                            created = "2026-06-30T08:53:10.438+00:00",
                            control = RemoteControl(
                                id = "fe5be3ff-95a7-41f4-b307-2e833f6add65",
                                station = "52",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "bd34d40c-844c-48a3-b6cd-d2afda3a937a",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:13:35.000+00:00",
                            points = 0L,
                            orderNumber = 1L,
                            created = "2026-06-30T08:53:10.420+00:00",
                            control = RemoteControl(
                                id = "7ef9b6b3-e877-4c0d-94f1-3b61ed26b6d4",
                                station = "51",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        )
                    )
                ),
                overalls = null
            ),
            RemoteResult(
                id = "096eb664-d773-4317-867a-e57fb0ea0628",
                bibNumber = "8618",
                isNc = false,
                eligibility = null,
                sicard = "7207937",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-06-30T08:53:10.948+00:00",
                runnerClass = RemoteClassResults(
                    id = "2c708bd2-cb93-4a56-a1ff-9471f1dfa590",
                    shortName = "F-21",
                    longName = "Feminino 21"
                ),
                runnerClub = RemoteClub(
                    id = "fba5b4ac-9a08-402c-9be1-3efe86c1dce5",
                    shortName = "Pontevedra AROMON"
                ),
                fullName = "Andrea Moledo Garía",
                stageResult = RemoteStageResult(
                    id = "4d7e15c0-af6f-4f08-9da2-841beaf2e7be",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-28T09:20:00.000+00:00",
                    finishTime = "2026-06-28T09:57:55.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2275L,
                    position = 0L,
                    statusCode = "3",
                    isNc = false,
                    contributory = true,
                    timeBehind = 682L,
                    timeNeutralization = 0L,
                    timeAdjusted = 0L,
                    timePenalty = 0L,
                    timeBonus = 0L,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 1L,
                    created = "2026-06-30T08:53:10.956+00:00",
                    splits = listOf(
                        RemoteSplit(
                            id = "6debdf4c-2e47-41d3-8901-d830004e685f",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:57:47.000+00:00",
                            points = 0L,
                            orderNumber = 22L,
                            created = "2026-06-30T08:53:11.184+00:00",
                            control = RemoteControl(
                                id = "6c5c5f62-08ca-4834-8fc8-d7d75138c363",
                                station = "100",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "f59d360c-08fb-435f-a64a-d22ea93e317f",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:55:50.000+00:00",
                            points = 0L,
                            orderNumber = 21L,
                            created = "2026-06-30T08:53:11.180+00:00",
                            control = RemoteControl(
                                id = "ea5e8c26-5a16-40ac-a7c9-8c1574c42bcd",
                                station = "75",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "98f0f01d-2242-4549-8d13-68e82f469de5",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:55:04.000+00:00",
                            points = 0L,
                            orderNumber = 20L,
                            created = "2026-06-30T08:53:11.169+00:00",
                            control = RemoteControl(
                                id = "157912be-832a-4d19-a804-074876dffdc3",
                                station = "57",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "7812e8a0-6f2e-40f7-8850-e186a9fc2a03",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:52:35.000+00:00",
                            points = 0L,
                            orderNumber = 19L,
                            created = "2026-06-30T08:53:11.163+00:00",
                            control = RemoteControl(
                                id = "865bcb3e-c783-438d-9ac9-216d7427e9ce",
                                station = "65",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "dd0327bf-6331-40a9-9351-f12839e36e20",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:51:45.000+00:00",
                            points = 0L,
                            orderNumber = 18L,
                            created = "2026-06-30T08:53:11.156+00:00",
                            control = RemoteControl(
                                id = "cacf4e42-e05e-456f-a9fe-0fa68cf06dcd",
                                station = "50",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "d799eb4d-c102-438f-9bba-7289033ea8b0",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:50:45.000+00:00",
                            points = 0L,
                            orderNumber = 17L,
                            created = "2026-06-30T08:53:11.140+00:00",
                            control = RemoteControl(
                                id = "3427e89d-d5b7-4c1f-b2d7-2bc0749df20a",
                                station = "53",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "8dd131ca-84bf-43a3-9507-43acc0aff620",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:47:49.000+00:00",
                            points = 0L,
                            orderNumber = 16L,
                            created = "2026-06-30T08:53:11.133+00:00",
                            control = RemoteControl(
                                id = "42bc473d-396d-488e-b7fc-d265bc58b1f2",
                                station = "49",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "967653ca-539b-488a-b8c1-b8320f3b3e61",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:44:53.000+00:00",
                            points = 0L,
                            orderNumber = 15L,
                            created = "2026-06-30T08:53:11.122+00:00",
                            control = RemoteControl(
                                id = "bded55d9-6d90-453f-9050-2e1e46b4fc00",
                                station = "41",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "fe7cc8f6-9ce2-43f0-92b7-e8176e7d25cc",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:40:03.000+00:00",
                            points = 0L,
                            orderNumber = 14L,
                            created = "2026-06-30T08:53:11.112+00:00",
                            control = RemoteControl(
                                id = "7ccf49e1-d48e-4c1c-95cd-f5989d6a9702",
                                station = "38",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "cc4dcfe2-597e-40e3-83ff-3a7bd9928c7a",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:38:43.000+00:00",
                            points = 0L,
                            orderNumber = 13L,
                            created = "2026-06-30T08:53:11.107+00:00",
                            control = RemoteControl(
                                id = "80b7f349-1106-4f59-90bf-b8fd5f58933f",
                                station = "37",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "52c86620-12ef-48f1-9910-dd1109e6e654",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:37:13.000+00:00",
                            points = 0L,
                            orderNumber = 12L,
                            created = "2026-06-30T08:53:11.076+00:00",
                            control = RemoteControl(
                                id = "11cfdefb-efb7-483a-856c-91110689c19b",
                                station = "36",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "6fcab7f1-44c1-46c3-919d-f3ea750ac28f",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:36:53.000+00:00",
                            points = 0L,
                            orderNumber = 11L,
                            created = "2026-06-30T08:53:11.067+00:00",
                            control = RemoteControl(
                                id = "8d07d63a-1153-49fd-8de9-c89a20fe0c9d",
                                station = "71",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "689dca5e-2a98-4077-b119-ff499323c8ab",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:35:04.000+00:00",
                            points = 0L,
                            orderNumber = 10L,
                            created = "2026-06-30T08:53:11.059+00:00",
                            control = RemoteControl(
                                id = "699aef52-a2b7-4fb4-9851-c6dfcc39bb8b",
                                station = "47",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "e7fa1f7d-7080-4db7-9519-7edb4bee93fe",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:34:24.000+00:00",
                            points = 0L,
                            orderNumber = 9L,
                            created = "2026-06-30T08:53:11.048+00:00",
                            control = RemoteControl(
                                id = "c0693939-3927-46d8-8567-ba2a334e0442",
                                station = "43",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "5eff0cd3-beb5-456d-a1a8-3f0985a2f227",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:33:14.000+00:00",
                            points = 0L,
                            orderNumber = 8L,
                            created = "2026-06-30T08:53:11.041+00:00",
                            control = RemoteControl(
                                id = "60cf13fa-1edd-449d-9461-333720b9d141",
                                station = "59",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "b35025e8-6dcb-4aae-8ed4-775ca32aeefd",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:31:08.000+00:00",
                            points = 0L,
                            orderNumber = 6L,
                            created = "2026-06-30T08:53:11.023+00:00",
                            control = RemoteControl(
                                id = "41b69055-bc0c-4523-b54d-42dfd8be5fb2",
                                station = "77",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "a27f472d-2261-44f3-992c-89071c939b5b",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:28:36.000+00:00",
                            points = 0L,
                            orderNumber = 5L,
                            created = "2026-06-30T08:53:11.009+00:00",
                            control = RemoteControl(
                                id = "127239de-227d-4e20-b2ad-aeafa2f8bc5a",
                                station = "81",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "1510bd1e-7272-40fe-89d7-84cecda38adc",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:26:42.000+00:00",
                            points = 0L,
                            orderNumber = 4L,
                            created = "2026-06-30T08:53:11.000+00:00",
                            control = RemoteControl(
                                id = "3d50f06c-35b7-48e6-945c-8fed925f0de6",
                                station = "82",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "ffcbb368-dd2c-4e83-ac62-42f2346aa097",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:25:28.000+00:00",
                            points = 0L,
                            orderNumber = 3L,
                            created = "2026-06-30T08:53:10.988+00:00",
                            control = RemoteControl(
                                id = "0088db1e-a2ab-40d8-ba68-68b922caf619",
                                station = "64",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "38621be7-4718-42d6-9095-5a2d06b76307",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:24:46.000+00:00",
                            points = 0L,
                            orderNumber = 2L,
                            created = "2026-06-30T08:53:10.978+00:00",
                            control = RemoteControl(
                                id = "fe5be3ff-95a7-41f4-b307-2e833f6add65",
                                station = "52",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "4e3b01e6-5561-41a7-9c42-c3affc2d0612",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:20:47.000+00:00",
                            points = 0L,
                            orderNumber = 1L,
                            created = "2026-06-30T08:53:10.964+00:00",
                            control = RemoteControl(
                                id = "7ef9b6b3-e877-4c0d-94f1-3b61ed26b6d4",
                                station = "51",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "24565655-6599-421a-bdaa-20ec8a7377f0",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 7L,
                            created = "2026-06-30T08:53:11.036+00:00",
                            control = RemoteControl(
                                id = "1397180c-25e4-4cef-b504-0d6b0c5e9246",
                                station = "44",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        )
                    )
                ),
                overalls = null
            ),
            RemoteResult(
                id = "589abd6b-8070-4d5d-b191-c02083c3a710",
                bibNumber = "4416",
                isNc = false,
                eligibility = null,
                sicard = "8501908",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-06-30T08:53:09.905+00:00",
                runnerClass = RemoteClassResults(
                    id = "2c708bd2-cb93-4a56-a1ff-9471f1dfa590",
                    shortName = "F-21",
                    longName = "Feminino 21"
                ),
                runnerClub = RemoteClub(
                    id = "56a05b83-e305-43a0-99f5-d255d77ff292",
                    shortName = "Culleredo GALLAECIA_RAID"
                ),
                fullName = "Silvia López López",
                stageResult = RemoteStageResult(
                    id = "ff065786-4cd8-47d3-a197-b0a7d2d61c83",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-28T08:52:00.000+00:00",
                    finishTime = "2026-06-28T09:24:33.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 1953L,
                    position = 2L,
                    statusCode = "0",
                    isNc = false,
                    contributory = true,
                    timeBehind = 360L,
                    timeNeutralization = 0L,
                    timeAdjusted = 0L,
                    timePenalty = 0L,
                    timeBonus = 0L,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 1L,
                    created = "2026-06-30T08:53:09.911+00:00",
                    splits = listOf(
                        RemoteSplit(
                            id = "3a1196a5-6307-4693-ba91-fa139bfaba0d",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:24:24.000+00:00",
                            points = 0L,
                            orderNumber = 22L,
                            created = "2026-06-30T08:53:10.148+00:00",
                            control = RemoteControl(
                                id = "6c5c5f62-08ca-4834-8fc8-d7d75138c363",
                                station = "100",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "5d604306-fd87-4932-bed5-e23fed7c8885",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:23:34.000+00:00",
                            points = 0L,
                            orderNumber = 21L,
                            created = "2026-06-30T08:53:10.136+00:00",
                            control = RemoteControl(
                                id = "ea5e8c26-5a16-40ac-a7c9-8c1574c42bcd",
                                station = "75",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "c3be5c94-53f3-48db-9983-9b73e1e2b184",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:22:45.000+00:00",
                            points = 0L,
                            orderNumber = 20L,
                            created = "2026-06-30T08:53:10.128+00:00",
                            control = RemoteControl(
                                id = "157912be-832a-4d19-a804-074876dffdc3",
                                station = "57",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "8d5fa34d-bf3d-445a-80d4-520df5adf61d",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:22:20.000+00:00",
                            points = 0L,
                            orderNumber = 19L,
                            created = "2026-06-30T08:53:10.120+00:00",
                            control = RemoteControl(
                                id = "865bcb3e-c783-438d-9ac9-216d7427e9ce",
                                station = "65",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "66819874-d596-45c2-9e3a-3cbcc4cc6646",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:20:57.000+00:00",
                            points = 0L,
                            orderNumber = 18L,
                            created = "2026-06-30T08:53:10.109+00:00",
                            control = RemoteControl(
                                id = "cacf4e42-e05e-456f-a9fe-0fa68cf06dcd",
                                station = "50",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "1f3d984c-99cd-45e9-92a0-dfd8e8b000e0",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:19:35.000+00:00",
                            points = 0L,
                            orderNumber = 17L,
                            created = "2026-06-30T08:53:10.100+00:00",
                            control = RemoteControl(
                                id = "3427e89d-d5b7-4c1f-b2d7-2bc0749df20a",
                                station = "53",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "8b0b5e83-a982-4122-b2d2-fe972aa383ef",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:16:35.000+00:00",
                            points = 0L,
                            orderNumber = 16L,
                            created = "2026-06-30T08:53:10.085+00:00",
                            control = RemoteControl(
                                id = "42bc473d-396d-488e-b7fc-d265bc58b1f2",
                                station = "49",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "894470bb-624d-4369-a848-d208a3800d63",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:13:52.000+00:00",
                            points = 0L,
                            orderNumber = 15L,
                            created = "2026-06-30T08:53:10.068+00:00",
                            control = RemoteControl(
                                id = "bded55d9-6d90-453f-9050-2e1e46b4fc00",
                                station = "41",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "daa63f0b-bac1-4de6-9f42-d2b122c998e1",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:11:33.000+00:00",
                            points = 0L,
                            orderNumber = 14L,
                            created = "2026-06-30T08:53:10.060+00:00",
                            control = RemoteControl(
                                id = "7ccf49e1-d48e-4c1c-95cd-f5989d6a9702",
                                station = "38",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "da9e8aa7-1ade-4468-a69a-bc99b68a3218",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:09:43.000+00:00",
                            points = 0L,
                            orderNumber = 13L,
                            created = "2026-06-30T08:53:10.048+00:00",
                            control = RemoteControl(
                                id = "80b7f349-1106-4f59-90bf-b8fd5f58933f",
                                station = "37",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "6113d094-bc6e-4f41-813f-538d896c9d8b",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:08:11.000+00:00",
                            points = 0L,
                            orderNumber = 12L,
                            created = "2026-06-30T08:53:10.038+00:00",
                            control = RemoteControl(
                                id = "11cfdefb-efb7-483a-856c-91110689c19b",
                                station = "36",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "a07c5bae-f376-498f-9e34-e0e245e152db",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:07:45.000+00:00",
                            points = 0L,
                            orderNumber = 11L,
                            created = "2026-06-30T08:53:10.030+00:00",
                            control = RemoteControl(
                                id = "8d07d63a-1153-49fd-8de9-c89a20fe0c9d",
                                station = "71",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "9f29d5e7-17e1-43a5-ba39-ad7d3c31c504",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:05:41.000+00:00",
                            points = 0L,
                            orderNumber = 10L,
                            created = "2026-06-30T08:53:10.020+00:00",
                            control = RemoteControl(
                                id = "699aef52-a2b7-4fb4-9851-c6dfcc39bb8b",
                                station = "47",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "b453a2d4-f5a3-44fa-8e8c-e37f34f22a37",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:04:54.000+00:00",
                            points = 0L,
                            orderNumber = 9L,
                            created = "2026-06-30T08:53:10.010+00:00",
                            control = RemoteControl(
                                id = "c0693939-3927-46d8-8567-ba2a334e0442",
                                station = "43",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "b3b5406f-87c9-43c5-9939-60ab52cfae76",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:04:14.000+00:00",
                            points = 0L,
                            orderNumber = 8L,
                            created = "2026-06-30T08:53:09.999+00:00",
                            control = RemoteControl(
                                id = "60cf13fa-1edd-449d-9461-333720b9d141",
                                station = "59",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "a56f77a3-5dd9-4ecc-8355-f17d8cc5a788",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:02:57.000+00:00",
                            points = 0L,
                            orderNumber = 7L,
                            created = "2026-06-30T08:53:09.988+00:00",
                            control = RemoteControl(
                                id = "1397180c-25e4-4cef-b504-0d6b0c5e9246",
                                station = "44",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "a5c57b55-6aed-4bee-901f-fec48d8dee33",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:57:51.000+00:00",
                            points = 0L,
                            orderNumber = 6L,
                            created = "2026-06-30T08:53:09.973+00:00",
                            control = RemoteControl(
                                id = "41b69055-bc0c-4523-b54d-42dfd8be5fb2",
                                station = "77",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "24941767-42f7-41c8-9096-05d60fc75259",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:56:52.000+00:00",
                            points = 0L,
                            orderNumber = 5L,
                            created = "2026-06-30T08:53:09.968+00:00",
                            control = RemoteControl(
                                id = "127239de-227d-4e20-b2ad-aeafa2f8bc5a",
                                station = "81",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "9f4e4d5d-8d3e-4c52-9b29-1bbf8fa972fe",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:56:10.000+00:00",
                            points = 0L,
                            orderNumber = 4L,
                            created = "2026-06-30T08:53:09.954+00:00",
                            control = RemoteControl(
                                id = "3d50f06c-35b7-48e6-945c-8fed925f0de6",
                                station = "82",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "06e6d42e-3965-4e3b-afb1-8d931f12a9e2",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:55:09.000+00:00",
                            points = 0L,
                            orderNumber = 3L,
                            created = "2026-06-30T08:53:09.939+00:00",
                            control = RemoteControl(
                                id = "0088db1e-a2ab-40d8-ba68-68b922caf619",
                                station = "64",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "36de1de0-c88b-46be-9b40-1fc484d62789",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:54:31.000+00:00",
                            points = 0L,
                            orderNumber = 2L,
                            created = "2026-06-30T08:53:09.930+00:00",
                            control = RemoteControl(
                                id = "fe5be3ff-95a7-41f4-b307-2e833f6add65",
                                station = "52",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "0a15ee22-0076-4721-a0b5-1b66df3a029d",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:52:45.000+00:00",
                            points = 0L,
                            orderNumber = 1L,
                            created = "2026-06-30T08:53:09.915+00:00",
                            control = RemoteControl(
                                id = "7ef9b6b3-e877-4c0d-94f1-3b61ed26b6d4",
                                station = "51",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        )
                    )
                ),
                overalls = null
            ),
            RemoteResult(
                id = "65ef7a0c-3ef8-489d-a3c6-f7c3526154c6",
                bibNumber = "8410",
                isNc = false,
                eligibility = null,
                sicard = "8437955",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-06-30T08:53:10.668+00:00",
                runnerClass = RemoteClassResults(
                    id = "2c708bd2-cb93-4a56-a1ff-9471f1dfa590",
                    shortName = "F-21",
                    longName = "Feminino 21"
                ),
                runnerClub = RemoteClub(
                    id = "7cc4518c-8430-47b6-9e6e-51591bcda3bc",
                    shortName = "Pontedeume MONTBREAMO"
                ),
                fullName = "Alba María Barros Fonte",
                stageResult = RemoteStageResult(
                    id = "85809cd1-28a8-4845-b7c0-c6bb062b2ade",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-28T08:59:00.000+00:00",
                    finishTime = "2026-06-28T09:41:25.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2545L,
                    position = 5L,
                    statusCode = "0",
                    isNc = false,
                    contributory = true,
                    timeBehind = 952L,
                    timeNeutralization = 0L,
                    timeAdjusted = 0L,
                    timePenalty = 0L,
                    timeBonus = 0L,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 1L,
                    created = "2026-06-30T08:53:10.686+00:00",
                    splits = listOf(
                        RemoteSplit(
                            id = "1628f174-d745-45fb-80fb-8eafa037e8b0",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:41:12.000+00:00",
                            points = 0L,
                            orderNumber = 22L,
                            created = "2026-06-30T08:53:10.937+00:00",
                            control = RemoteControl(
                                id = "6c5c5f62-08ca-4834-8fc8-d7d75138c363",
                                station = "100",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "1fee87e4-842d-4163-9b57-659d8d565ad3",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:40:29.000+00:00",
                            points = 0L,
                            orderNumber = 21L,
                            created = "2026-06-30T08:53:10.929+00:00",
                            control = RemoteControl(
                                id = "ea5e8c26-5a16-40ac-a7c9-8c1574c42bcd",
                                station = "75",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "ad9cabb9-7e9a-40a6-bb4a-90bf06a90f22",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:39:48.000+00:00",
                            points = 0L,
                            orderNumber = 20L,
                            created = "2026-06-30T08:53:10.916+00:00",
                            control = RemoteControl(
                                id = "157912be-832a-4d19-a804-074876dffdc3",
                                station = "57",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "6324a7c4-e9da-4a83-9d0d-b6148797d472",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:39:21.000+00:00",
                            points = 0L,
                            orderNumber = 19L,
                            created = "2026-06-30T08:53:10.905+00:00",
                            control = RemoteControl(
                                id = "865bcb3e-c783-438d-9ac9-216d7427e9ce",
                                station = "65",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "cbddbdf8-8331-48a4-8076-46772bafd78b",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:35:13.000+00:00",
                            points = 0L,
                            orderNumber = 18L,
                            created = "2026-06-30T08:53:10.899+00:00",
                            control = RemoteControl(
                                id = "cacf4e42-e05e-456f-a9fe-0fa68cf06dcd",
                                station = "50",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "17f8355e-8f7b-4a3d-8ecb-a1a337f003d3",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:34:16.000+00:00",
                            points = 0L,
                            orderNumber = 17L,
                            created = "2026-06-30T08:53:10.885+00:00",
                            control = RemoteControl(
                                id = "3427e89d-d5b7-4c1f-b2d7-2bc0749df20a",
                                station = "53",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "c1d6e8e6-3cd9-4dc6-976f-d291388e082c",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:27:22.000+00:00",
                            points = 0L,
                            orderNumber = 16L,
                            created = "2026-06-30T08:53:10.868+00:00",
                            control = RemoteControl(
                                id = "42bc473d-396d-488e-b7fc-d265bc58b1f2",
                                station = "49",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "2804a816-985d-4d42-b6b5-362f3efb7f8a",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:23:55.000+00:00",
                            points = 0L,
                            orderNumber = 15L,
                            created = "2026-06-30T08:53:10.858+00:00",
                            control = RemoteControl(
                                id = "bded55d9-6d90-453f-9050-2e1e46b4fc00",
                                station = "41",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "c2e7cd59-9a2f-49df-bbcf-f1982f5acaf8",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:18:24.000+00:00",
                            points = 0L,
                            orderNumber = 14L,
                            created = "2026-06-30T08:53:10.850+00:00",
                            control = RemoteControl(
                                id = "7ccf49e1-d48e-4c1c-95cd-f5989d6a9702",
                                station = "38",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "2153087f-6ed6-49d4-acf4-e9cc3a026088",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:16:44.000+00:00",
                            points = 0L,
                            orderNumber = 13L,
                            created = "2026-06-30T08:53:10.833+00:00",
                            control = RemoteControl(
                                id = "80b7f349-1106-4f59-90bf-b8fd5f58933f",
                                station = "37",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "6231372f-e460-4435-a065-1051f3aa0177",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:14:21.000+00:00",
                            points = 0L,
                            orderNumber = 12L,
                            created = "2026-06-30T08:53:10.827+00:00",
                            control = RemoteControl(
                                id = "11cfdefb-efb7-483a-856c-91110689c19b",
                                station = "36",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "1ebc91ea-cb0e-42ef-95af-f8fcecfcf158",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:12:56.000+00:00",
                            points = 0L,
                            orderNumber = 11L,
                            created = "2026-06-30T08:53:10.796+00:00",
                            control = RemoteControl(
                                id = "8d07d63a-1153-49fd-8de9-c89a20fe0c9d",
                                station = "71",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "16fe630f-f8a3-414b-8199-c3d451fb53a8",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:11:15.000+00:00",
                            points = 0L,
                            orderNumber = 10L,
                            created = "2026-06-30T08:53:10.785+00:00",
                            control = RemoteControl(
                                id = "699aef52-a2b7-4fb4-9851-c6dfcc39bb8b",
                                station = "47",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "cc1da079-6752-48fe-92d0-d7edbf23e4fb",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:10:39.000+00:00",
                            points = 0L,
                            orderNumber = 9L,
                            created = "2026-06-30T08:53:10.777+00:00",
                            control = RemoteControl(
                                id = "c0693939-3927-46d8-8567-ba2a334e0442",
                                station = "43",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "ffb5dc3e-f9cd-4376-b4f5-310714b718c3",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:09:47.000+00:00",
                            points = 0L,
                            orderNumber = 8L,
                            created = "2026-06-30T08:53:10.767+00:00",
                            control = RemoteControl(
                                id = "60cf13fa-1edd-449d-9461-333720b9d141",
                                station = "59",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "a9411551-e137-4570-853c-56bcfdab75ea",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:08:38.000+00:00",
                            points = 0L,
                            orderNumber = 7L,
                            created = "2026-06-30T08:53:10.751+00:00",
                            control = RemoteControl(
                                id = "1397180c-25e4-4cef-b504-0d6b0c5e9246",
                                station = "44",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "405a4330-f651-4f12-8c15-5437c803a12d",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:05:38.000+00:00",
                            points = 0L,
                            orderNumber = 6L,
                            created = "2026-06-30T08:53:10.743+00:00",
                            control = RemoteControl(
                                id = "41b69055-bc0c-4523-b54d-42dfd8be5fb2",
                                station = "77",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "544af08d-1596-4244-a7f1-fce459c97174",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:04:35.000+00:00",
                            points = 0L,
                            orderNumber = 5L,
                            created = "2026-06-30T08:53:10.733+00:00",
                            control = RemoteControl(
                                id = "127239de-227d-4e20-b2ad-aeafa2f8bc5a",
                                station = "81",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "3b90c9be-c04f-49d8-b5f8-97b5079fbff0",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:03:45.000+00:00",
                            points = 0L,
                            orderNumber = 4L,
                            created = "2026-06-30T08:53:10.727+00:00",
                            control = RemoteControl(
                                id = "3d50f06c-35b7-48e6-945c-8fed925f0de6",
                                station = "82",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "7e01bd95-aeb4-4571-b966-855a247f8a7a",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:02:42.000+00:00",
                            points = 0L,
                            orderNumber = 3L,
                            created = "2026-06-30T08:53:10.718+00:00",
                            control = RemoteControl(
                                id = "0088db1e-a2ab-40d8-ba68-68b922caf619",
                                station = "64",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "025b4602-b484-47de-90b1-49b50b461ad6",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:01:39.000+00:00",
                            points = 0L,
                            orderNumber = 2L,
                            created = "2026-06-30T08:53:10.707+00:00",
                            control = RemoteControl(
                                id = "fe5be3ff-95a7-41f4-b307-2e833f6add65",
                                station = "52",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "bd1fa3c8-2d74-412a-bf5f-d353d958bd1d",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:59:53.000+00:00",
                            points = 0L,
                            orderNumber = 1L,
                            created = "2026-06-30T08:53:10.694+00:00",
                            control = RemoteControl(
                                id = "7ef9b6b3-e877-4c0d-94f1-3b61ed26b6d4",
                                station = "51",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        )
                    )
                ),
                overalls = null
            ),
            RemoteResult(
                id = "8e4b4180-8547-4ef4-82ad-089f61349938",
                bibNumber = "4268",
                isNc = false,
                eligibility = null,
                sicard = "2015866",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-06-30T08:53:10.156+00:00",
                runnerClass = RemoteClassResults(
                    id = "2c708bd2-cb93-4a56-a1ff-9471f1dfa590",
                    shortName = "F-21",
                    longName = "Feminino 21"
                ),
                runnerClub = RemoteClub(
                    id = "3cf08ac2-1149-4bce-a8e1-4328dde19c15",
                    shortName = "A Coruña ARTABROS"
                ),
                fullName = "Carlota Garcia López",
                stageResult = RemoteStageResult(
                    id = "ecebfee9-6ec9-43e9-ac0b-5416385b7b17",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-28T09:06:00.000+00:00",
                    finishTime = "2026-06-28T09:43:02.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2222L,
                    position = 3L,
                    statusCode = "0",
                    isNc = false,
                    contributory = true,
                    timeBehind = 629L,
                    timeNeutralization = 0L,
                    timeAdjusted = 0L,
                    timePenalty = 0L,
                    timeBonus = 0L,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 1L,
                    created = "2026-06-30T08:53:10.169+00:00",
                    splits = listOf(
                        RemoteSplit(
                            id = "0a541480-cf1d-41fd-a135-46a8302b8fc7",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:42:51.000+00:00",
                            points = 0L,
                            orderNumber = 22L,
                            created = "2026-06-30T08:53:10.383+00:00",
                            control = RemoteControl(
                                id = "6c5c5f62-08ca-4834-8fc8-d7d75138c363",
                                station = "100",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "e2bcbb4d-9a14-4230-a2d9-26a92b359c64",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:42:16.000+00:00",
                            points = 0L,
                            orderNumber = 21L,
                            created = "2026-06-30T08:53:10.379+00:00",
                            control = RemoteControl(
                                id = "ea5e8c26-5a16-40ac-a7c9-8c1574c42bcd",
                                station = "75",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "d499577e-b07d-4f8d-983d-8620ee1b61ae",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:41:13.000+00:00",
                            points = 0L,
                            orderNumber = 20L,
                            created = "2026-06-30T08:53:10.369+00:00",
                            control = RemoteControl(
                                id = "157912be-832a-4d19-a804-074876dffdc3",
                                station = "57",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "ef81cb70-c576-40a6-ab1b-00127b86bf15",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:40:41.000+00:00",
                            points = 0L,
                            orderNumber = 19L,
                            created = "2026-06-30T08:53:10.361+00:00",
                            control = RemoteControl(
                                id = "865bcb3e-c783-438d-9ac9-216d7427e9ce",
                                station = "65",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "bd38ede8-51b8-468d-a53b-e5e85fbe9a5d",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:39:57.000+00:00",
                            points = 0L,
                            orderNumber = 18L,
                            created = "2026-06-30T08:53:10.351+00:00",
                            control = RemoteControl(
                                id = "cacf4e42-e05e-456f-a9fe-0fa68cf06dcd",
                                station = "50",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "800b64c2-b616-48c4-b61c-715faa977c06",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:38:38.000+00:00",
                            points = 0L,
                            orderNumber = 17L,
                            created = "2026-06-30T08:53:10.339+00:00",
                            control = RemoteControl(
                                id = "3427e89d-d5b7-4c1f-b2d7-2bc0749df20a",
                                station = "53",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "eab5462e-d7d8-4dee-ba54-f230efeb4391",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:36:13.000+00:00",
                            points = 0L,
                            orderNumber = 16L,
                            created = "2026-06-30T08:53:10.331+00:00",
                            control = RemoteControl(
                                id = "42bc473d-396d-488e-b7fc-d265bc58b1f2",
                                station = "49",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "2ac4e4f1-0d1e-4b36-8383-96ff0fb48308",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:33:18.000+00:00",
                            points = 0L,
                            orderNumber = 15L,
                            created = "2026-06-30T08:53:10.307+00:00",
                            control = RemoteControl(
                                id = "bded55d9-6d90-453f-9050-2e1e46b4fc00",
                                station = "41",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "2b032b90-2bc0-4f63-aa57-530e175bc7d0",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:29:43.000+00:00",
                            points = 0L,
                            orderNumber = 14L,
                            created = "2026-06-30T08:53:10.303+00:00",
                            control = RemoteControl(
                                id = "7ccf49e1-d48e-4c1c-95cd-f5989d6a9702",
                                station = "38",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "3b53547b-e764-4aa8-9077-fb215244cbbd",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:27:37.000+00:00",
                            points = 0L,
                            orderNumber = 13L,
                            created = "2026-06-30T08:53:10.294+00:00",
                            control = RemoteControl(
                                id = "80b7f349-1106-4f59-90bf-b8fd5f58933f",
                                station = "37",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "465a33c1-0f50-4cc0-83f1-63215a491aee",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:25:52.000+00:00",
                            points = 0L,
                            orderNumber = 12L,
                            created = "2026-06-30T08:53:10.285+00:00",
                            control = RemoteControl(
                                id = "11cfdefb-efb7-483a-856c-91110689c19b",
                                station = "36",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "66baa595-b398-45dc-87dd-80a1474b4d44",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:25:28.000+00:00",
                            points = 0L,
                            orderNumber = 11L,
                            created = "2026-06-30T08:53:10.274+00:00",
                            control = RemoteControl(
                                id = "8d07d63a-1153-49fd-8de9-c89a20fe0c9d",
                                station = "71",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "179d0673-d5d0-46bc-aa32-cd0336f10c30",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:23:08.000+00:00",
                            points = 0L,
                            orderNumber = 10L,
                            created = "2026-06-30T08:53:10.266+00:00",
                            control = RemoteControl(
                                id = "699aef52-a2b7-4fb4-9851-c6dfcc39bb8b",
                                station = "47",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "31d98d3a-698e-407c-8c63-cbc55b0e9535",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:22:22.000+00:00",
                            points = 0L,
                            orderNumber = 9L,
                            created = "2026-06-30T08:53:10.255+00:00",
                            control = RemoteControl(
                                id = "c0693939-3927-46d8-8567-ba2a334e0442",
                                station = "43",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "e90b35c9-a5e0-4d58-aeba-505e28f9e7b0",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:21:36.000+00:00",
                            points = 0L,
                            orderNumber = 8L,
                            created = "2026-06-30T08:53:10.245+00:00",
                            control = RemoteControl(
                                id = "60cf13fa-1edd-449d-9461-333720b9d141",
                                station = "59",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "642256ac-e645-4e66-85f3-fd1bdcaf93c2",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:20:34.000+00:00",
                            points = 0L,
                            orderNumber = 7L,
                            created = "2026-06-30T08:53:10.240+00:00",
                            control = RemoteControl(
                                id = "1397180c-25e4-4cef-b504-0d6b0c5e9246",
                                station = "44",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "8faf81a1-fe83-437d-807b-e6a2603ea255",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:19:05.000+00:00",
                            points = 0L,
                            orderNumber = 6L,
                            created = "2026-06-30T08:53:10.229+00:00",
                            control = RemoteControl(
                                id = "41b69055-bc0c-4523-b54d-42dfd8be5fb2",
                                station = "77",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "745729e1-892b-421c-85b1-be43d3e71086",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:17:19.000+00:00",
                            points = 0L,
                            orderNumber = 5L,
                            created = "2026-06-30T08:53:10.221+00:00",
                            control = RemoteControl(
                                id = "127239de-227d-4e20-b2ad-aeafa2f8bc5a",
                                station = "81",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "d75da70d-e582-49cc-8f58-415496d55f0f",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:10:56.000+00:00",
                            points = 0L,
                            orderNumber = 4L,
                            created = "2026-06-30T08:53:10.203+00:00",
                            control = RemoteControl(
                                id = "3d50f06c-35b7-48e6-945c-8fed925f0de6",
                                station = "82",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "0de6f413-ac27-4de0-8c60-edae0ec7378a",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:10:05.000+00:00",
                            points = 0L,
                            orderNumber = 3L,
                            created = "2026-06-30T08:53:10.194+00:00",
                            control = RemoteControl(
                                id = "0088db1e-a2ab-40d8-ba68-68b922caf619",
                                station = "64",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "a7204636-217e-40e2-b1c6-9d41c900c153",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:09:28.000+00:00",
                            points = 0L,
                            orderNumber = 2L,
                            created = "2026-06-30T08:53:10.185+00:00",
                            control = RemoteControl(
                                id = "fe5be3ff-95a7-41f4-b307-2e833f6add65",
                                station = "52",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "1754e327-4d27-413a-bd5d-19c23c71453a",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:08:01.000+00:00",
                            points = 0L,
                            orderNumber = 1L,
                            created = "2026-06-30T08:53:10.176+00:00",
                            control = RemoteControl(
                                id = "7ef9b6b3-e877-4c0d-94f1-3b61ed26b6d4",
                                station = "51",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        )
                    )
                ),
                overalls = null
            ),
            RemoteResult(
                id = "d3fa5295-7787-4524-a048-b0254deb142c",
                bibNumber = "7461",
                isNc = false,
                eligibility = null,
                sicard = "8545840",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-06-30T08:53:09.534+00:00",
                runnerClass = RemoteClassResults(
                    id = "2c708bd2-cb93-4a56-a1ff-9471f1dfa590",
                    shortName = "F-21",
                    longName = "Feminino 21"
                ),
                runnerClub = RemoteClub(
                    id = "056e0cc3-1e65-4f64-bdae-dbffb8fa28be",
                    shortName = "Nigrán RAZA PALLEIRA"
                ),
                fullName = "Nerea Loira Camiña",
                stageResult = RemoteStageResult(
                    id = "4d9d1697-190d-46f8-b6e3-6bfe3f4a2134",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-28T08:45:00.000+00:00",
                    finishTime = "2026-06-28T09:11:33.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 1593L,
                    position = 1L,
                    statusCode = "0",
                    isNc = false,
                    contributory = true,
                    timeBehind = 0L,
                    timeNeutralization = 0L,
                    timeAdjusted = 0L,
                    timePenalty = 0L,
                    timeBonus = 0L,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 1L,
                    created = "2026-06-30T08:53:09.545+00:00",
                    splits = listOf(
                        RemoteSplit(
                            id = "c8a25b2d-84ea-4a66-b196-f6a330b6429d",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:11:27.000+00:00",
                            points = 0L,
                            orderNumber = 22L,
                            created = "2026-06-30T08:53:09.887+00:00",
                            control = RemoteControl(
                                id = "6c5c5f62-08ca-4834-8fc8-d7d75138c363",
                                station = "100",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "317b16d7-d29a-409d-bdaf-3e129c3d2628",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:11:08.000+00:00",
                            points = 0L,
                            orderNumber = 21L,
                            created = "2026-06-30T08:53:09.876+00:00",
                            control = RemoteControl(
                                id = "ea5e8c26-5a16-40ac-a7c9-8c1574c42bcd",
                                station = "75",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "febb1b49-ccb3-433d-9855-5c34be084444",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:10:27.000+00:00",
                            points = 0L,
                            orderNumber = 20L,
                            created = "2026-06-30T08:53:09.862+00:00",
                            control = RemoteControl(
                                id = "157912be-832a-4d19-a804-074876dffdc3",
                                station = "57",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "b4adfe79-eb69-4d89-89a7-b8b8dd66c46a",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:09:45.000+00:00",
                            points = 0L,
                            orderNumber = 19L,
                            created = "2026-06-30T08:53:09.852+00:00",
                            control = RemoteControl(
                                id = "865bcb3e-c783-438d-9ac9-216d7427e9ce",
                                station = "65",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "f7a297c5-f663-492d-b0ef-8d92364ab752",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:09:09.000+00:00",
                            points = 0L,
                            orderNumber = 18L,
                            created = "2026-06-30T08:53:09.836+00:00",
                            control = RemoteControl(
                                id = "cacf4e42-e05e-456f-a9fe-0fa68cf06dcd",
                                station = "50",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "b521baec-9bd4-4725-a908-85fd5e8a31fa",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:07:34.000+00:00",
                            points = 0L,
                            orderNumber = 17L,
                            created = "2026-06-30T08:53:09.817+00:00",
                            control = RemoteControl(
                                id = "3427e89d-d5b7-4c1f-b2d7-2bc0749df20a",
                                station = "53",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "cf08126e-ca09-4545-bf1c-8f067c7f18c7",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:04:54.000+00:00",
                            points = 0L,
                            orderNumber = 16L,
                            created = "2026-06-30T08:53:09.791+00:00",
                            control = RemoteControl(
                                id = "42bc473d-396d-488e-b7fc-d265bc58b1f2",
                                station = "49",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "4f55cccd-1df0-4041-acbe-2742c152d8fd",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:03:12.000+00:00",
                            points = 0L,
                            orderNumber = 15L,
                            created = "2026-06-30T08:53:09.781+00:00",
                            control = RemoteControl(
                                id = "bded55d9-6d90-453f-9050-2e1e46b4fc00",
                                station = "41",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "14e72a02-6b3a-48ec-8e43-854183d8c4bf",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:01:19.000+00:00",
                            points = 0L,
                            orderNumber = 14L,
                            created = "2026-06-30T08:53:09.770+00:00",
                            control = RemoteControl(
                                id = "7ccf49e1-d48e-4c1c-95cd-f5989d6a9702",
                                station = "38",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "b47a54d8-2b2f-4145-bd23-1fe06b6d3ecd",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:59:24.000+00:00",
                            points = 0L,
                            orderNumber = 13L,
                            created = "2026-06-30T08:53:09.740+00:00",
                            control = RemoteControl(
                                id = "80b7f349-1106-4f59-90bf-b8fd5f58933f",
                                station = "37",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "180790c9-afb0-49e2-afda-c7c2a86b1f41",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:55:44.000+00:00",
                            points = 0L,
                            orderNumber = 12L,
                            created = "2026-06-30T08:53:09.732+00:00",
                            control = RemoteControl(
                                id = "11cfdefb-efb7-483a-856c-91110689c19b",
                                station = "36",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "e4be502e-6983-48d4-b306-bf5984e20697",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:55:27.000+00:00",
                            points = 0L,
                            orderNumber = 11L,
                            created = "2026-06-30T08:53:09.717+00:00",
                            control = RemoteControl(
                                id = "8d07d63a-1153-49fd-8de9-c89a20fe0c9d",
                                station = "71",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "1261f925-11e5-4ceb-abc4-66d8a13e9902",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:54:16.000+00:00",
                            points = 0L,
                            orderNumber = 10L,
                            created = "2026-06-30T08:53:09.700+00:00",
                            control = RemoteControl(
                                id = "699aef52-a2b7-4fb4-9851-c6dfcc39bb8b",
                                station = "47",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "bb2770be-9196-4f1e-9f5e-4150b575c29f",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:52:51.000+00:00",
                            points = 0L,
                            orderNumber = 9L,
                            created = "2026-06-30T08:53:09.689+00:00",
                            control = RemoteControl(
                                id = "c0693939-3927-46d8-8567-ba2a334e0442",
                                station = "43",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "8bdd3d31-2867-419d-af61-922c5698ebba",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:52:15.000+00:00",
                            points = 0L,
                            orderNumber = 8L,
                            created = "2026-06-30T08:53:09.670+00:00",
                            control = RemoteControl(
                                id = "60cf13fa-1edd-449d-9461-333720b9d141",
                                station = "59",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "dffe9a78-1bb8-480b-994b-dda8cd279efa",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:51:21.000+00:00",
                            points = 0L,
                            orderNumber = 7L,
                            created = "2026-06-30T08:53:09.651+00:00",
                            control = RemoteControl(
                                id = "1397180c-25e4-4cef-b504-0d6b0c5e9246",
                                station = "44",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "c8a6b522-9da7-45da-8cba-8a36951667c6",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:50:19.000+00:00",
                            points = 0L,
                            orderNumber = 6L,
                            created = "2026-06-30T08:53:09.631+00:00",
                            control = RemoteControl(
                                id = "41b69055-bc0c-4523-b54d-42dfd8be5fb2",
                                station = "77",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "c8c532b0-fe22-4183-8e9c-0482f8b57cd1",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:49:15.000+00:00",
                            points = 0L,
                            orderNumber = 5L,
                            created = "2026-06-30T08:53:09.617+00:00",
                            control = RemoteControl(
                                id = "127239de-227d-4e20-b2ad-aeafa2f8bc5a",
                                station = "81",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "1c8d2ba9-7fec-49d5-a37e-20212d0a6c9a",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:48:35.000+00:00",
                            points = 0L,
                            orderNumber = 4L,
                            created = "2026-06-30T08:53:09.606+00:00",
                            control = RemoteControl(
                                id = "3d50f06c-35b7-48e6-945c-8fed925f0de6",
                                station = "82",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "f6a38bfd-2dae-4fee-b4cd-ae9b45ffd122",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:47:31.000+00:00",
                            points = 0L,
                            orderNumber = 3L,
                            created = "2026-06-30T08:53:09.601+00:00",
                            control = RemoteControl(
                                id = "0088db1e-a2ab-40d8-ba68-68b922caf619",
                                station = "64",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "9cfd09f8-2134-470c-a229-1c6f2aa5552d",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:46:47.000+00:00",
                            points = 0L,
                            orderNumber = 2L,
                            created = "2026-06-30T08:53:09.581+00:00",
                            control = RemoteControl(
                                id = "fe5be3ff-95a7-41f4-b307-2e833f6add65",
                                station = "52",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "3bf489f7-c337-4814-9297-a85b8a86131c",
                            isIntermediate = false,
                            readingTime = "2026-06-28T08:45:31.000+00:00",
                            points = 0L,
                            orderNumber = 1L,
                            created = "2026-06-30T08:53:09.553+00:00",
                            control = RemoteControl(
                                id = "7ef9b6b3-e877-4c0d-94f1-3b61ed26b6d4",
                                station = "51",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        )
                    )
                ),
                overalls = null
            )
        )
    )

    val allNulls = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "02c0298a-d3e5-470e-8ae2-77a40063b407",
                bibNumber = "4346",
                isNc = false,
                eligibility = null,
                sicard = "2077088",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-06-30T08:53:10.392+00:00",
                runnerClass = null,
                runnerClub = null,
                fullName = "Julia Pérez Álvarez",
                stageResult = null,
                overalls = null
            ),
        )
    )

    val noReadingTime = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "02c0298a-d3e5-470e-8ae2-77a40063b407",
                bibNumber = "4346",
                isNc = false,
                eligibility = null,
                sicard = "2077088",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-06-30T08:53:10.392+00:00",
                runnerClass = RemoteClassResults(
                    id = "2c708bd2-cb93-4a56-a1ff-9471f1dfa590",
                    shortName = "F-21",
                    longName = "Feminino 21"
                ),
                runnerClub = RemoteClub(
                    id = "8aec7d3c-5e45-4a80-b459-93d7514d507c",
                    shortName = "Vigo U-VIGO"
                ),
                fullName = "Julia Pérez Álvarez",
                stageResult = RemoteStageResult(
                    id = "40062c79-1ccd-4c98-bfbe-a58ddd7f7096",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-28T09:13:00.000+00:00",
                    finishTime = "2026-06-28T09:51:03.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2283L,
                    position = 4L,
                    statusCode = "0",
                    isNc = false,
                    contributory = true,
                    timeBehind = 690L,
                    timeNeutralization = 0L,
                    timeAdjusted = 0L,
                    timePenalty = 0L,
                    timeBonus = 0L,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 1L,
                    created = "2026-06-30T08:53:10.402+00:00",
                    splits = listOf(
                        RemoteSplit(
                            id = "ea17d001-1dfc-4b6a-8c78-7eb2eb0d4096",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 22L,
                            created = "2026-06-30T08:53:10.658+00:00",
                            control = RemoteControl(
                                id = "6c5c5f62-08ca-4834-8fc8-d7d75138c363",
                                station = "100",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "c8af39f9-c402-424a-a0fa-9d961f5ef635",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 21L,
                            created = "2026-06-30T08:53:10.646+00:00",
                            control = RemoteControl(
                                id = "ea5e8c26-5a16-40ac-a7c9-8c1574c42bcd",
                                station = "75",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "541aa644-8dd1-42fd-a1fb-921c64335a1e",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 20L,
                            created = "2026-06-30T08:53:10.636+00:00",
                            control = RemoteControl(
                                id = "157912be-832a-4d19-a804-074876dffdc3",
                                station = "57",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "cedd814e-7817-497e-a664-4b5e2c095aed",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 19L,
                            created = "2026-06-30T08:53:10.627+00:00",
                            control = RemoteControl(
                                id = "865bcb3e-c783-438d-9ac9-216d7427e9ce",
                                station = "65",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "0002c0fd-5488-4917-9184-7fba2b8c65bd",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 18L,
                            created = "2026-06-30T08:53:10.618+00:00",
                            control = RemoteControl(
                                id = "cacf4e42-e05e-456f-a9fe-0fa68cf06dcd",
                                station = "50",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "38ba786b-a63e-4e0d-bdea-98125ab17bd9",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 17L,
                            created = "2026-06-30T08:53:10.595+00:00",
                            control = RemoteControl(
                                id = "3427e89d-d5b7-4c1f-b2d7-2bc0749df20a",
                                station = "53",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "f9f5a7d5-0aab-4ebe-a136-47f79ed9ca73",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 16L,
                            created = "2026-06-30T08:53:10.566+00:00",
                            control = RemoteControl(
                                id = "42bc473d-396d-488e-b7fc-d265bc58b1f2",
                                station = "49",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "537c9ed4-6afa-4eb1-b7da-5d0dfa186164",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 15L,
                            created = "2026-06-30T08:53:10.555+00:00",
                            control = RemoteControl(
                                id = "bded55d9-6d90-453f-9050-2e1e46b4fc00",
                                station = "41",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "7d695b2c-ac1f-4ac9-a120-e487b65ec464",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 14L,
                            created = "2026-06-30T08:53:10.545+00:00",
                            control = RemoteControl(
                                id = "7ccf49e1-d48e-4c1c-95cd-f5989d6a9702",
                                station = "38",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "64297f00-9df1-4e43-97e0-9404d045a0cb",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 13L,
                            created = "2026-06-30T08:53:10.536+00:00",
                            control = RemoteControl(
                                id = "80b7f349-1106-4f59-90bf-b8fd5f58933f",
                                station = "37",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "96823c33-381a-417f-b87d-8f3b5c33c3fc",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 12L,
                            created = "2026-06-30T08:53:10.527+00:00",
                            control = RemoteControl(
                                id = "11cfdefb-efb7-483a-856c-91110689c19b",
                                station = "36",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "a1ed9aed-1410-4763-8169-405f6585d198",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 11L,
                            created = "2026-06-30T08:53:10.516+00:00",
                            control = RemoteControl(
                                id = "8d07d63a-1153-49fd-8de9-c89a20fe0c9d",
                                station = "71",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "45837732-b902-40a9-8d07-55d47c309694",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 10L,
                            created = "2026-06-30T08:53:10.508+00:00",
                            control = RemoteControl(
                                id = "699aef52-a2b7-4fb4-9851-c6dfcc39bb8b",
                                station = "47",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "1f8f4403-99a2-4d72-a3e6-16e63aaac8d5",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 9L,
                            created = "2026-06-30T08:53:10.499+00:00",
                            control = RemoteControl(
                                id = "c0693939-3927-46d8-8567-ba2a334e0442",
                                station = "43",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "708f80e8-feba-4d0f-a8c4-7c353df55595",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 8L,
                            created = "2026-06-30T08:53:10.491+00:00",
                            control = RemoteControl(
                                id = "60cf13fa-1edd-449d-9461-333720b9d141",
                                station = "59",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "91119fa0-7c1f-4275-9215-1bf49ae1bc8a",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 7L,
                            created = "2026-06-30T08:53:10.486+00:00",
                            control = RemoteControl(
                                id = "1397180c-25e4-4cef-b504-0d6b0c5e9246",
                                station = "44",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "0401581a-c170-4b12-b03c-e6b6d502eb08",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 6L,
                            created = "2026-06-30T08:53:10.477+00:00",
                            control = RemoteControl(
                                id = "41b69055-bc0c-4523-b54d-42dfd8be5fb2",
                                station = "77",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "5796d33b-ef8f-496c-b4e1-ce265b2c6483",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 5L,
                            created = "2026-06-30T08:53:10.468+00:00",
                            control = RemoteControl(
                                id = "127239de-227d-4e20-b2ad-aeafa2f8bc5a",
                                station = "81",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "7a1db23a-a1f7-4a64-b2ad-d740af8cb795",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 4L,
                            created = "2026-06-30T08:53:10.453+00:00",
                            control = RemoteControl(
                                id = "3d50f06c-35b7-48e6-945c-8fed925f0de6",
                                station = "82",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "ede6c7a8-953c-4653-afa2-f1a398f2b87d",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 3L,
                            created = "2026-06-30T08:53:10.446+00:00",
                            control = RemoteControl(
                                id = "0088db1e-a2ab-40d8-ba68-68b922caf619",
                                station = "64",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "66368887-01dd-4bf2-b204-70ad3c3d1d0d",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 2L,
                            created = "2026-06-30T08:53:10.438+00:00",
                            control = RemoteControl(
                                id = "fe5be3ff-95a7-41f4-b307-2e833f6add65",
                                station = "52",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "bd34d40c-844c-48a3-b6cd-d2afda3a937a",
                            isIntermediate = false,
                            readingTime = null,
                            points = 0L,
                            orderNumber = 1L,
                            created = "2026-06-30T08:53:10.420+00:00",
                            control = RemoteControl(
                                id = "7ef9b6b3-e877-4c0d-94f1-3b61ed26b6d4",
                                station = "51",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        )
                    )
                ),
                overalls = null
            )
        )
    )

    val noSplits = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "02c0298a-d3e5-470e-8ae2-77a40063b407",
                bibNumber = "4346",
                isNc = false,
                eligibility = null,
                sicard = "2077088",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-06-30T08:53:10.392+00:00",
                runnerClass = RemoteClassResults(
                    id = "2c708bd2-cb93-4a56-a1ff-9471f1dfa590",
                    shortName = "F-21",
                    longName = "Feminino 21"
                ),
                runnerClub = RemoteClub(
                    id = "8aec7d3c-5e45-4a80-b459-93d7514d507c",
                    shortName = "Vigo U-VIGO"
                ),
                fullName = "Julia Pérez Álvarez",
                stageResult = RemoteStageResult(
                    id = "40062c79-1ccd-4c98-bfbe-a58ddd7f7096",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-28T09:13:00.000+00:00",
                    finishTime = "2026-06-28T09:51:03.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2283L,
                    position = 4L,
                    statusCode = "0",
                    isNc = false,
                    contributory = true,
                    timeBehind = 690L,
                    timeNeutralization = 0L,
                    timeAdjusted = 0L,
                    timePenalty = 0L,
                    timeBonus = 0L,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 1L,
                    created = "2026-06-30T08:53:10.402+00:00",
                    splits = emptyList()
                ),
                overalls = null
            )
        )
    )

    val extraSplit = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "02c0298a-d3e5-470e-8ae2-77a40063b407",
                bibNumber = "4346",
                isNc = false,
                eligibility = null,
                sicard = "2077088",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-06-30T08:53:10.392+00:00",
                runnerClass = RemoteClassResults(
                    id = "2c708bd2-cb93-4a56-a1ff-9471f1dfa590",
                    shortName = "F-21",
                    longName = "Feminino 21"
                ),
                runnerClub = RemoteClub(
                    id = "8aec7d3c-5e45-4a80-b459-93d7514d507c",
                    shortName = "Vigo U-VIGO"
                ),
                fullName = "Julia Pérez Álvarez",
                stageResult = RemoteStageResult(
                    id = "40062c79-1ccd-4c98-bfbe-a58ddd7f7096",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-28T09:13:00.000+00:00",
                    finishTime = "2026-06-28T09:51:03.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2283L,
                    position = 4L,
                    statusCode = "0",
                    isNc = false,
                    contributory = true,
                    timeBehind = 690L,
                    timeNeutralization = 0L,
                    timeAdjusted = 0L,
                    timePenalty = 0L,
                    timeBonus = 0L,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 1L,
                    created = "2026-06-30T08:53:10.402+00:00",
                    splits = listOf(
                        RemoteSplit(
                            id = "ea17d001-1dfc-4b6a-8c78-7eb2eb0d4096",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:14:00.000+00:00",
                            points = 0L,
                            orderNumber = 1L,
                            created = "2026-06-30T08:53:10.658+00:00",
                            control = RemoteControl(
                                id = "6c5c5f62-08ca-4834-8fc8-d7d75138c363",
                                station = "100",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        ),
                        RemoteSplit(
                            id = "c8af39f9-c402-424a-a0fa-9d961f5ef635",
                            isIntermediate = false,
                            readingTime = "2026-06-28T09:16:00.000+00:00",
                            points = 0L,
                            orderNumber = null,
                            created = "2026-06-30T08:53:10.646+00:00",
                            control = RemoteControl(
                                id = "ea5e8c26-5a16-40ac-a7c9-8c1574c42bcd",
                                station = "75",
                                controlType = ControlType(
                                    id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                    description = "Normal Control"
                                )
                            )
                        )
                    )
                ),
                overalls = null
            )
        )
    )

    val overallResponse = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "d55125db-c179-4392-a553-a579b116a333",
                bibNumber = "4785",
                isNc = false,
                eligibility = null,
                sicard = "8664271",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-04-01T07:22:10.018+00:00",
                runnerClass = RemoteClassResults(
                    id = "db730c5a-51af-4225-8315-ee13ae9c9c71",
                    shortName = "F-65",
                    longName = "Femenino 65"
                ),
                runnerClub = RemoteClub(
                    id = "1caffb4f-63b1-43b7-b2af-2200de634f1f",
                    shortName = "A Coruña LICEO"
                ),
                fullName = "Mª José Naya López",
                stageResult = null,
                overalls = RemoteOverallResult(
                    parts = listOf(
                        RemoteOverall(
                            id = "a5332eef-29e9-4484-ad7b-c4d132793223",
                            stageOrder = 1L,
                            uploadType = "total_points",
                            stage = RemoteStageOveralls(
                                id = "bbdc0398-3ced-4054-bc80-7e77b957805c",
                                description = "01 Paderne"
                            ),
                            position = 1L,
                            statusCode = "0",
                            isNc = false,
                            contributory = true,
                            timeSeconds = 0L,
                            timeBehind = 0L,
                            pointsFinal = 100L,
                            pointsBehind = null,
                            note = null
                        ),
                        RemoteOverall(
                            id = "f278711a-c089-45cc-b504-28ff19f5b324",
                            stageOrder = 2L,
                            uploadType = "total_points",
                            stage = RemoteStageOveralls(
                                id = "e655e86a-2cd1-458b-b5a8-5a8023bca910",
                                description = "02 Abadin"
                            ),
                            position = 2L,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeSeconds = 0L,
                            timeBehind = 0L,
                            pointsFinal = 83L,
                            pointsBehind = null,
                            note = null
                        ),
                        RemoteOverall(
                            id = "d5cd0837-b3a7-48a4-828a-437594785be7",
                            stageOrder = 3L,
                            uploadType = "total_points",
                            stage = RemoteStageOveralls(
                                id = "963de8e8-dfc3-4c2e-8bdb-7544a371fd92",
                                description = "03 Segade"
                            ),
                            position = 1L,
                            statusCode = "0",
                            isNc = false,
                            contributory = true,
                            timeSeconds = 0L,
                            timeBehind = 0L,
                            pointsFinal = 100L,
                            pointsBehind = null,
                            note = null
                        ),
                        RemoteOverall(
                            id = "be80d22b-ff32-47cb-a79b-83ba04df2e09",
                            stageOrder = 4L,
                            uploadType = "total_points",
                            stage = RemoteStageOveralls(
                                id = "7065d804-3adb-4f97-8231-6557e0a7d96d",
                                description = "04 Oleiros"
                            ),
                            position = 1L,
                            statusCode = "0",
                            isNc = false,
                            contributory = true,
                            timeSeconds = 0L,
                            timeBehind = 0L,
                            pointsFinal = 100L,
                            pointsBehind = null,
                            note = null
                        ),
                        RemoteOverall(
                            id = "e43acf5b-1619-4a40-8101-ab19835fb9e0",
                            stageOrder = 5L,
                            uploadType = "total_points",
                            stage = RemoteStageOveralls(
                                id = "f7cb5ea4-1ae0-4579-af3f-c3dc9bf9ea0f",
                                description = "05 O Grove"
                            ),
                            position = 1L,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeSeconds = 0L,
                            timeBehind = 0L,
                            pointsFinal = 100L,
                            pointsBehind = null,
                            note = null
                        )
                    ),
                    overall = RemoteOverall(
                        id = "",
                        stageOrder = 1L,
                        uploadType = "ranking_computed",
                        stage = null,
                        position = 1L,
                        statusCode = "0",
                        isNc = null,
                        contributory = null,
                        timeSeconds = 0L,
                        timeBehind = null,
                        pointsFinal = 300L,
                        pointsBehind = null,
                        note = null
                    )
                )
            ),
            RemoteResult(
                id = "74b0df07-9949-4c9d-b00d-4d11b49f17d4",
                bibNumber = "4405",
                isNc = false,
                eligibility = null,
                sicard = "8027202",
                sex = "F",
                legNumber = 1L,
                legs = null,
                runners = null,
                created = "2026-04-01T07:23:03.166+00:00",
                runnerClass = RemoteClassResults(
                    id = "db730c5a-51af-4225-8315-ee13ae9c9c71",
                    shortName = "F-65",
                    longName = "Femenino 65"
                ),
                runnerClub = RemoteClub(
                    id = "9e11d2d2-c1c4-428f-a871-7c78b842c438",
                    shortName = "Culleredo GALLAECIA_RAID"
                ),
                fullName = "Adriana Luisa González Sención",
                stageResult = null,
                overalls = RemoteOverallResult(
                    parts = listOf(
                        RemoteOverall(
                            id = "ac13de8a-e475-49d1-8923-60e6d0d7cee4",
                            stageOrder = 2L,
                            uploadType = "total_points",
                            stage = RemoteStageOveralls(
                                id = "e655e86a-2cd1-458b-b5a8-5a8023bca910",
                                description = "02 Abadin"
                            ),
                            position = 1L,
                            statusCode = "0",
                            isNc = false,
                            contributory = true,
                            timeSeconds = 0L,
                            timeBehind = 0L,
                            pointsFinal = 100L,
                            pointsBehind = null,
                            note = null
                        ),
                        RemoteOverall(
                            id = "eece5e77-c94f-4bcb-a7b9-13aa7ce38102",
                            stageOrder = 3L,
                            uploadType = "total_points",
                            stage = RemoteStageOveralls(
                                id = "963de8e8-dfc3-4c2e-8bdb-7544a371fd92",
                                description = "03 Segade"
                            ),
                            position = 0L,
                            statusCode = "0",
                            isNc = false,
                            contributory = true,
                            timeSeconds = 0L,
                            timeBehind = 0L,
                            pointsFinal = 0L,
                            pointsBehind = null,
                            note = null
                        ),
                        RemoteOverall(
                            id = "348d51df-5bff-4dbe-98e5-3f2768ecc942",
                            stageOrder = 4L,
                            uploadType = "total_points",
                            stage = RemoteStageOveralls(
                                id = "7065d804-3adb-4f97-8231-6557e0a7d96d",
                                description = "04 Oleiros"
                            ),
                            position = 0L,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeSeconds = 0L,
                            timeBehind = 0L,
                            pointsFinal = 0L,
                            pointsBehind = null,
                            note = null
                        ),
                        RemoteOverall(
                            id = "42648fee-a847-4798-9111-82e9ce1d6945",
                            stageOrder = 5L,
                            uploadType = "total_points",
                            stage = RemoteStageOveralls(
                                id = "f7cb5ea4-1ae0-4579-af3f-c3dc9bf9ea0f",
                                description = "05 O Grove"
                            ),
                            position = 2L,
                            statusCode = "0",
                            isNc = false,
                            contributory = true,
                            timeSeconds = 0L,
                            timeBehind = 0L,
                            pointsFinal = 89L,
                            pointsBehind = null,
                            note = null
                        )
                    ),
                    overall = RemoteOverall(
                        id = "",
                        stageOrder = 1L,
                        uploadType = "ranking_computed",
                        stage = null,
                        position = 2L,
                        statusCode = "0",
                        isNc = null,
                        contributory = null,
                        timeSeconds = 0L,
                        timeBehind = null,
                        pointsFinal = 189L,
                        pointsBehind = null,
                        note = null
                    )
                )
            )
        )
    )

    val teamValid = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "05f2f7a6-c2ee-4d9f-bda2-a674c44d7c89",
                bibNumber = "103",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:40.788+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "60e2e363-43ab-4a99-b4b1-dfa165401bfb",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:40.815+00:00",
                        runners = null,
                        sicard = "8513969",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Glòria Teixidor Gala",
                        stageResult = RemoteStageResult(
                            id = "2b66abdd-eaed-48a2-870a-c36a625d784a",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:53:30.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 1590,
                            position = 0,
                            statusCode = "3",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:40.826+00:00",
                            splits = listOf(
                                RemoteSplit(
                                    id = "0fd8bac2-b861-4640-8047-390039dab1e6",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:52:54.000+00:00",
                                    points = 0,
                                    orderNumber = 11,
                                    created = "2026-06-22T09:12:40.921+00:00",
                                    control = RemoteControl(
                                        id = "3e94fe42-4a6f-406d-8d70-472595ac3fc2",
                                        station = "200",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "246ddfd3-b2f4-4813-9ad9-0b334198af75",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:50:31.000+00:00",
                                    points = 0,
                                    orderNumber = 10,
                                    created = "2026-06-22T09:12:40.906+00:00",
                                    control = RemoteControl(
                                        id = "28bf2d20-989d-40b0-bbcf-01b45595edb2",
                                        station = "41",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "9b9e1601-56e3-4f52-8cbb-2ad74a4926a3",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:48:14.000+00:00",
                                    points = 0,
                                    orderNumber = 8,
                                    created = "2026-06-22T09:12:40.889+00:00",
                                    control = RemoteControl(
                                        id = "ee4e007c-7077-4b56-a615-ae44d89b05f0",
                                        station = "53",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "3a97a6d4-ffe3-43ed-9add-5faed5c681e4",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:46:29.000+00:00",
                                    points = 0,
                                    orderNumber = 7,
                                    created = "2026-06-22T09:12:40.885+00:00",
                                    control = RemoteControl(
                                        id = "b38bb112-adc9-40bb-a769-416cf821d37f",
                                        station = "62",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "7bf13ef9-c0a6-4161-9902-2de533491184",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:45:57.000+00:00",
                                    points = 0,
                                    orderNumber = 6,
                                    created = "2026-06-22T09:12:40.872+00:00",
                                    control = RemoteControl(
                                        id = "6b68c19f-3e70-465c-919a-7780b4b2fd79",
                                        station = "100",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "3ec5ff00-4c5d-478e-bea3-756e7fbd08df",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:45:45.000+00:00",
                                    points = 0,
                                    orderNumber = 5,
                                    created = "2026-06-22T09:12:40.862+00:00",
                                    control = RemoteControl(
                                        id = "2519730a-620f-4e5d-9a12-360e7ff6f131",
                                        station = "52",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "f2f96bf0-8a80-4da1-9559-c42098659b3c",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:44:15.000+00:00",
                                    points = 0,
                                    orderNumber = 4,
                                    created = "2026-06-22T09:12:40.854+00:00",
                                    control = RemoteControl(
                                        id = "92249eb5-d50c-49c7-8fb7-6adb0cdb970f",
                                        station = "48",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "8cb178c6-b469-4f48-bc02-a2828cd43883",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:43:45.000+00:00",
                                    points = 0,
                                    orderNumber = 3,
                                    created = "2026-06-22T09:12:40.846+00:00",
                                    control = RemoteControl(
                                        id = "28449696-8690-4d5d-bd90-44e8c1882a03",
                                        station = "42",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "d6992263-f0a4-4367-8a78-8e08aef4d1e1",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:40:49.000+00:00",
                                    points = 0,
                                    orderNumber = 2,
                                    created = "2026-06-22T09:12:40.839+00:00",
                                    control = RemoteControl(
                                        id = "898ace0b-02ac-48a2-84f0-98215ad418a9",
                                        station = "47",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "88ab42ab-b58d-4765-989b-8fc0e8fa577c",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:32:56.000+00:00",
                                    points = 0,
                                    orderNumber = 1,
                                    created = "2026-06-22T09:12:40.833+00:00",
                                    control = RemoteControl(
                                        id = "deb121e6-5c61-4648-b041-3facd001e586",
                                        station = "46",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "015da0f5-e729-40d7-9618-933fa267bcc5",
                                    isIntermediate = false,
                                    readingTime = null,
                                    points = 0,
                                    orderNumber = 9,
                                    created = "2026-06-22T09:12:40.896+00:00",
                                    control = RemoteControl(
                                        id = "8eecbd7a-4d45-4af1-bbfb-3755e60315b7",
                                        station = "44",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                )
                            )
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "0c4c046b-83ea-4617-8b54-c3b091764d78",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:40.931+00:00",
                        runners = null,
                        sicard = "8047320",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Roger Puig Finazzi",
                        stageResult = RemoteStageResult(
                            id = "bcc28b85-3916-4bf6-879c-ab2840f8f39c",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:53:30.000+00:00",
                            finishTime = "2026-06-22T08:02:27.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 537,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:40.942+00:00",
                            splits = listOf(
                                RemoteSplit(
                                    id = "a41bc7fb-5d65-4d5c-bc94-83db92b46632",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:02:00.000+00:00",
                                    points = 0,
                                    orderNumber = 11,
                                    created = "2026-06-22T09:12:41.072+00:00",
                                    control = RemoteControl(
                                        id = "3e94fe42-4a6f-406d-8d70-472595ac3fc2",
                                        station = "200",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "987bc940-5d1d-4ad5-a145-24a6d590c8c9",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:01:27.000+00:00",
                                    points = 0,
                                    orderNumber = 10,
                                    created = "2026-06-22T09:12:41.064+00:00",
                                    control = RemoteControl(
                                        id = "28bf2d20-989d-40b0-bbcf-01b45595edb2",
                                        station = "41",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "93e88fa5-a7e4-43b2-bcb5-797947db3cdb",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:00:17.000+00:00",
                                    points = 0,
                                    orderNumber = 9,
                                    created = "2026-06-22T09:12:41.056+00:00",
                                    control = RemoteControl(
                                        id = "43020912-dcb9-4d4a-a5e6-6e5c8167c8ee",
                                        station = "43",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "15ac8e8d-f0e9-4c1b-8c45-6185f946134b",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:59:08.000+00:00",
                                    points = 0,
                                    orderNumber = 8,
                                    created = "2026-06-22T09:12:41.048+00:00",
                                    control = RemoteControl(
                                        id = "ee4e007c-7077-4b56-a615-ae44d89b05f0",
                                        station = "53",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "1c31cdc3-47a9-4cfa-a2c6-7069a06f6d4d",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:58:10.000+00:00",
                                    points = 0,
                                    orderNumber = 7,
                                    created = "2026-06-22T09:12:41.038+00:00",
                                    control = RemoteControl(
                                        id = "b38bb112-adc9-40bb-a769-416cf821d37f",
                                        station = "62",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "5a0db199-2975-46c3-ba90-de70a68556e5",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:57:43.000+00:00",
                                    points = 0,
                                    orderNumber = 6,
                                    created = "2026-06-22T09:12:41.024+00:00",
                                    control = RemoteControl(
                                        id = "6b68c19f-3e70-465c-919a-7780b4b2fd79",
                                        station = "100",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "e1415c10-56dd-478c-9abd-9584479532cb",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:57:34.000+00:00",
                                    points = 0,
                                    orderNumber = 5,
                                    created = "2026-06-22T09:12:41.013+00:00",
                                    control = RemoteControl(
                                        id = "2519730a-620f-4e5d-9a12-360e7ff6f131",
                                        station = "52",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "5da02fbf-3fef-4df6-9b73-d65e170ae4c7",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:56:31.000+00:00",
                                    points = 0,
                                    orderNumber = 4,
                                    created = "2026-06-22T09:12:40.994+00:00",
                                    control = RemoteControl(
                                        id = "2f1c8a5d-0083-4e51-b913-812b3d96f760",
                                        station = "51",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "1b4d22b7-01c5-4c72-8a56-dee7095d9fbf",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:55:45.000+00:00",
                                    points = 0,
                                    orderNumber = 3,
                                    created = "2026-06-22T09:12:40.971+00:00",
                                    control = RemoteControl(
                                        id = "28449696-8690-4d5d-bd90-44e8c1882a03",
                                        station = "42",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "cfaeffe9-2293-4754-b651-ff2fac1c4e17",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:55:10.000+00:00",
                                    points = 0,
                                    orderNumber = 2,
                                    created = "2026-06-22T09:12:40.961+00:00",
                                    control = RemoteControl(
                                        id = "898ace0b-02ac-48a2-84f0-98215ad418a9",
                                        station = "47",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "da53f8d4-5b7d-4273-918c-965cfcadc260",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T07:54:30.000+00:00",
                                    points = 0,
                                    orderNumber = 1,
                                    created = "2026-06-22T09:12:40.951+00:00",
                                    control = RemoteControl(
                                        id = "0a2ff946-7195-437a-ac42-6f04e31ef22c",
                                        station = "45",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                )
                            )
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "94174e0d-ac02-4a6b-926a-34735274b48e",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:41.077+00:00",
                        runners = null,
                        sicard = "8501211",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Roc Bausà Ginesti",
                        stageResult = RemoteStageResult(
                            id = "a7ae4eba-b79b-4d66-ba21-38e86810b5eb",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T08:02:27.000+00:00",
                            finishTime = "2026-06-22T08:10:13.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 465,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:41.088+00:00",
                            splits = listOf(
                                RemoteSplit(
                                    id = "251f3533-01f9-47cd-abc5-e6f087793581",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:09:46.000+00:00",
                                    points = 0,
                                    orderNumber = 11,
                                    created = "2026-06-22T09:12:41.243+00:00",
                                    control = RemoteControl(
                                        id = "3e94fe42-4a6f-406d-8d70-472595ac3fc2",
                                        station = "200",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "d7f1942c-50e7-474b-92c6-22e30cc0177c",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:09:21.000+00:00",
                                    points = 0,
                                    orderNumber = 10,
                                    created = "2026-06-22T09:12:41.230+00:00",
                                    control = RemoteControl(
                                        id = "28bf2d20-989d-40b0-bbcf-01b45595edb2",
                                        station = "41",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "c3be9a3d-08e4-428d-9200-3fead7ab4a80",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:08:27.000+00:00",
                                    points = 0,
                                    orderNumber = 9,
                                    created = "2026-06-22T09:12:41.220+00:00",
                                    control = RemoteControl(
                                        id = "8eecbd7a-4d45-4af1-bbfb-3755e60315b7",
                                        station = "44",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "ed9d510b-8d29-4233-8788-68665bc44ca0",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:07:50.000+00:00",
                                    points = 0,
                                    orderNumber = 8,
                                    created = "2026-06-22T09:12:41.212+00:00",
                                    control = RemoteControl(
                                        id = "ee4e007c-7077-4b56-a615-ae44d89b05f0",
                                        station = "53",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "50bb6506-6651-4bfa-af90-b5b74076750f",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:07:00.000+00:00",
                                    points = 0,
                                    orderNumber = 7,
                                    created = "2026-06-22T09:12:41.201+00:00",
                                    control = RemoteControl(
                                        id = "b38bb112-adc9-40bb-a769-416cf821d37f",
                                        station = "62",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "5fd67c6e-f7fe-4141-b3ba-94b6e4cac7c8",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:06:32.000+00:00",
                                    points = 0,
                                    orderNumber = 6,
                                    created = "2026-06-22T09:12:41.189+00:00",
                                    control = RemoteControl(
                                        id = "6b68c19f-3e70-465c-919a-7780b4b2fd79",
                                        station = "100",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "a2db6462-799c-447a-93fa-bfcceadc061c",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:06:22.000+00:00",
                                    points = 0,
                                    orderNumber = 5,
                                    created = "2026-06-22T09:12:41.180+00:00",
                                    control = RemoteControl(
                                        id = "2519730a-620f-4e5d-9a12-360e7ff6f131",
                                        station = "52",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "d7ee6ce3-5360-4538-a9dd-a0830d03d206",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:05:09.000+00:00",
                                    points = 0,
                                    orderNumber = 4,
                                    created = "2026-06-22T09:12:41.171+00:00",
                                    control = RemoteControl(
                                        id = "b14af3dd-d883-44b5-9189-8e073379fa5e",
                                        station = "50",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "99ca557e-81fc-400b-86c7-c082a8bac1da",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:04:27.000+00:00",
                                    points = 0,
                                    orderNumber = 3,
                                    created = "2026-06-22T09:12:41.149+00:00",
                                    control = RemoteControl(
                                        id = "28449696-8690-4d5d-bd90-44e8c1882a03",
                                        station = "42",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "4f28f338-7ae1-41c1-b030-f1293322f970",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:03:53.000+00:00",
                                    points = 0,
                                    orderNumber = 2,
                                    created = "2026-06-22T09:12:41.113+00:00",
                                    control = RemoteControl(
                                        id = "898ace0b-02ac-48a2-84f0-98215ad418a9",
                                        station = "47",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "268ef42d-16b2-4468-90e6-d48209d837a9",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:03:10.000+00:00",
                                    points = 0,
                                    orderNumber = 1,
                                    created = "2026-06-22T09:12:41.104+00:00",
                                    control = RemoteControl(
                                        id = "deb121e6-5c61-4648-b041-3facd001e586",
                                        station = "46",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                )
                            )
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "e139c02d-15f0-4c51-9e46-b5f8ba338632",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:41.259+00:00",
                        runners = null,
                        sicard = "8530910",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Magalí Casafont Viñals",
                        stageResult = RemoteStageResult(
                            id = "d2f2ebc2-87b8-4340-bfbf-764f87808810",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T08:10:13.000+00:00",
                            finishTime = "2026-06-22T08:22:58.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 764,
                            position = 8,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:12:41.269+00:00",
                            splits = listOf(
                                RemoteSplit(
                                    id = "685a0c55-3858-43a3-afd2-2e5e83a80e00",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:22:24.000+00:00",
                                    points = 0,
                                    orderNumber = 11,
                                    created = "2026-06-22T09:12:41.366+00:00",
                                    control = RemoteControl(
                                        id = "3e94fe42-4a6f-406d-8d70-472595ac3fc2",
                                        station = "200",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "d83c0074-616c-42ee-8256-bba5c2b559ab",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:21:41.000+00:00",
                                    points = 0,
                                    orderNumber = 10,
                                    created = "2026-06-22T09:12:41.358+00:00",
                                    control = RemoteControl(
                                        id = "28bf2d20-989d-40b0-bbcf-01b45595edb2",
                                        station = "41",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "91804819-24fd-454e-a1c8-74f7054b8b73",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:20:20.000+00:00",
                                    points = 0,
                                    orderNumber = 9,
                                    created = "2026-06-22T09:12:41.350+00:00",
                                    control = RemoteControl(
                                        id = "43020912-dcb9-4d4a-a5e6-6e5c8167c8ee",
                                        station = "43",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "702c3fbc-4234-4fef-bd83-f68bf1667ca3",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:18:25.000+00:00",
                                    points = 0,
                                    orderNumber = 8,
                                    created = "2026-06-22T09:12:41.342+00:00",
                                    control = RemoteControl(
                                        id = "ee4e007c-7077-4b56-a615-ae44d89b05f0",
                                        station = "53",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "ef4a5b55-3d60-4aef-bb4b-4ea91ac09bd8",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:16:58.000+00:00",
                                    points = 0,
                                    orderNumber = 7,
                                    created = "2026-06-22T09:12:41.335+00:00",
                                    control = RemoteControl(
                                        id = "b38bb112-adc9-40bb-a769-416cf821d37f",
                                        station = "62",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "ab04fcef-3418-417f-b611-14f42924c464",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:16:14.000+00:00",
                                    points = 0,
                                    orderNumber = 6,
                                    created = "2026-06-22T09:12:41.322+00:00",
                                    control = RemoteControl(
                                        id = "6b68c19f-3e70-465c-919a-7780b4b2fd79",
                                        station = "100",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                ),
                                RemoteSplit(
                                    id = "7f5ab2d2-2bf6-4205-a804-342e67ad6267",
                                    isIntermediate = false,
                                    readingTime = "2026-06-22T08:16:02.000+00:00",
                                    points = 0,
                                    orderNumber = 5,
                                    created = "2026-06-22T09:12:41.312+00:00",
                                    control = RemoteControl(
                                        id = "2519730a-620f-4e5d-9a12-360e7ff6f131",
                                        station = "52",
                                        controlType = ControlType(
                                            id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                                            description = "Normal Control"
                                        )
                                    )
                                )
                            )
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "929f889e-ef99-4e54-ae2f-05c8e4a39f01",
                    shortName = "INFANTIL",
                    longName = "INFANTIL"
                ),
                runnerClub = RemoteClub(
                    id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                    shortName = "CATALUNYA"
                ),
                fullName = "CATALUNYA A",
                stageResult = RemoteStageResult(
                    id = "5159b41f-378a-4e30-8e67-af2c1553ea5d",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:22:58.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 0,
                    position = 0,
                    statusCode = "3",
                    isNc = false,
                    contributory = null,
                    timeBehind = 0,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:40.808+00:00",
                    splits = emptyList()
                ),
                overalls = null
            )
        )
    )

    val teamNoSplits = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "888da5ab-c5d4-47e5-800b-ecfd6f9ca904",
                bibNumber = "125",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:40.173+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "f69f20ad-a680-4b3c-90b9-3935b679d871",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:40.210+00:00",
                        runners = null,
                        sicard = "8525829",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "588cc1c9-40a6-4e9d-a7be-51e22b288c67",
                            shortName = "CASTILLA Y LEÓN"
                        ),
                        fullName = "Sofia Estebanez Calvo",
                        stageResult = RemoteStageResult(
                            id = "ba4de47f-c3f9-41f3-ab22-238a9c005899",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:40:40.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 820,
                            position = 7,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:40.220+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "bd082b4c-d14c-4791-9ecf-f7b8487bbe1b",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:40.349+00:00",
                        runners = null,
                        sicard = "8310312",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "588cc1c9-40a6-4e9d-a7be-51e22b288c67",
                            shortName = "CASTILLA Y LEÓN"
                        ),
                        fullName = "Jaime García Alonso",
                        stageResult = RemoteStageResult(
                            id = "be4dfc68-28d9-4100-82ab-c607bab493f0",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:40:40.000+00:00",
                            finishTime = "2026-06-22T07:49:43.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 542,
                            position = 3,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:40.359+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "d844bb05-5362-480f-a8bf-0ddaeebfafb0",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:40.498+00:00",
                        runners = null,
                        sicard = "8121529",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "588cc1c9-40a6-4e9d-a7be-51e22b288c67",
                            shortName = "CASTILLA Y LEÓN"
                        ),
                        fullName = "Adrian Sanz Guerra",
                        stageResult = RemoteStageResult(
                            id = "3c3bda6a-35b4-47a6-9dec-e6a2765c2242",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:49:43.000+00:00",
                            finishTime = "2026-06-22T08:00:12.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 629,
                            position = 11,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:40.506+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "9f19c1a6-e1a7-4861-840a-c891376db8f7",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:40.660+00:00",
                        runners = null,
                        sicard = "8522508",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "588cc1c9-40a6-4e9d-a7be-51e22b288c67",
                            shortName = "CASTILLA Y LEÓN"
                        ),
                        fullName = "Alba Bayón Población",
                        stageResult = RemoteStageResult(
                            id = "f0474df3-6198-48da-a39a-0c7ef9f230ae",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T08:00:12.000+00:00",
                            finishTime = "2026-06-22T08:09:58.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 585,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:12:40.671+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "929f889e-ef99-4e54-ae2f-05c8e4a39f01",
                    shortName = "INFANTIL",
                    longName = "INFANTIL"
                ),
                runnerClub = RemoteClub(
                    id = "588cc1c9-40a6-4e9d-a7be-51e22b288c67",
                    shortName = "CASTILLA Y LEÓN"
                ),
                fullName = "CASTILLA Y LEÓN A",
                stageResult = RemoteStageResult(
                    id = "032441e0-3db4-4570-b0db-872b4c7dcaa0",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:09:58.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2578,
                    position = 2,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 47,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:40.200+00:00",
                    splits = emptyList()
                ),
                overalls = null
            )
        )
    )

    val teamMissingData = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "888da5ab-c5d4-47e5-800b-ecfd6f9ca904",
                bibNumber = "125",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:40.173+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "f69f20ad-a680-4b3c-90b9-3935b679d871",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:40.210+00:00",
                        runners = null,
                        sicard = "8525829",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "588cc1c9-40a6-4e9d-a7be-51e22b288c67",
                            shortName = "CASTILLA Y LEÓN"
                        ),
                        fullName = "Sofia Estebanez Calvo",
                        stageResult = RemoteStageResult(
                            id = "ba4de47f-c3f9-41f3-ab22-238a9c005899",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:40:40.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 820,
                            position = 7,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:40.220+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "bd082b4c-d14c-4791-9ecf-f7b8487bbe1b",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:40.349+00:00",
                        runners = null,
                        sicard = "8310312",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "588cc1c9-40a6-4e9d-a7be-51e22b288c67",
                            shortName = "CASTILLA Y LEÓN"
                        ),
                        fullName = "Jaime García Alonso",
                        stageResult = RemoteStageResult(
                            id = "be4dfc68-28d9-4100-82ab-c607bab493f0",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:40:40.000+00:00",
                            finishTime = "2026-06-22T07:49:43.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 542,
                            position = 3,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:40.359+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "d844bb05-5362-480f-a8bf-0ddaeebfafb0",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:40.498+00:00",
                        runners = null,
                        sicard = "8121529",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "588cc1c9-40a6-4e9d-a7be-51e22b288c67",
                            shortName = "CASTILLA Y LEÓN"
                        ),
                        fullName = "Adrian Sanz Guerra",
                        stageResult = RemoteStageResult(
                            id = "3c3bda6a-35b4-47a6-9dec-e6a2765c2242",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:49:43.000+00:00",
                            finishTime = "2026-06-22T08:00:12.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 629,
                            position = 11,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:40.506+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "9f19c1a6-e1a7-4861-840a-c891376db8f7",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:40.660+00:00",
                        runners = null,
                        sicard = "8522508",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "588cc1c9-40a6-4e9d-a7be-51e22b288c67",
                            shortName = "CASTILLA Y LEÓN"
                        ),
                        fullName = "Alba Bayón Población",
                        stageResult = RemoteStageResult(
                            id = "f0474df3-6198-48da-a39a-0c7ef9f230ae",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T08:00:12.000+00:00",
                            finishTime = "2026-06-22T08:09:58.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 585,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:12:40.671+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = null,
                runnerClub = null,
                fullName = "CASTILLA Y LEÓN A",
                stageResult = null,
                overalls = null
            )
        )
    )

    val teamNoRunners = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "888da5ab-c5d4-47e5-800b-ecfd6f9ca904",
                bibNumber = "125",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:40.173+00:00",
                runners = null,
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "929f889e-ef99-4e54-ae2f-05c8e4a39f01",
                    shortName = "INFANTIL",
                    longName = "INFANTIL"
                ),
                runnerClub = RemoteClub(
                    id = "588cc1c9-40a6-4e9d-a7be-51e22b288c67",
                    shortName = "CASTILLA Y LEÓN"
                ),
                fullName = "CASTILLA Y LEÓN A",
                stageResult = RemoteStageResult(
                    id = "032441e0-3db4-4570-b0db-872b4c7dcaa0",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:09:58.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2578,
                    position = 2,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 47,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:40.200+00:00",
                    splits = emptyList()
                ),
                overalls = null
            )
        )
    )

    val teamRanksValid = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "8cc0b48c-942a-4582-a461-5d5660b0142f",
                bibNumber = "202",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:59.505+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "2a11fd65-8d9e-4238-b64a-0e123bc191f6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.534+00:00",
                        runners = null,
                        sicard = "8291111",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Marta Nogués Vives",
                        stageResult = RemoteStageResult(
                            id = "63e9ecea-7934-4751-b624-bd67b2942aab",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:38:25.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 685,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:59.545+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "01d3e13d-e3f8-4970-abd9-2306c6ef328c",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.708+00:00",
                        runners = null,
                        sicard = "8328677",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Joel Rufo Franch",
                        stageResult = RemoteStageResult(
                            id = "831e04fd-766e-4b88-a952-f2bff43dc3ce",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:38:25.000+00:00",
                            finishTime = "2026-06-22T07:46:46.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 500,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:59.716+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "b21e193a-62b5-4d9a-9c62-3c3a8240c134",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.863+00:00",
                        runners = null,
                        sicard = "8511773",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Martí Hernandez Oliveras",
                        stageResult = RemoteStageResult(
                            id = "cd45fe2e-1213-4b5a-ac3d-959e1485378a",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:46:46.000+00:00",
                            finishTime = "2026-06-22T07:55:36.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 530,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:59.870+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "f7890230-4491-4d71-87e5-25ccb5b02c12",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:13:00.004+00:00",
                        runners = null,
                        sicard = "8513878",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Sira Font Torrentó",
                        stageResult = RemoteStageResult(
                            id = "8e904a41-efdf-4548-bc14-d167510c8c02",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:36.000+00:00",
                            finishTime = "2026-06-22T08:05:06.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 569,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:13:00.011+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                    shortName = "CATALUNYA"
                ),
                fullName = "CATALUNYA A",
                stageResult = RemoteStageResult(
                    id = "e25f0cc4-dfdd-47da-bffd-e0ca8aa68e7b",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:05:06.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2286,
                    position = 1,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 0,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:59.525+00:00",
                    splits = emptyList()
                ),
                overalls = null
            ),
            RemoteResult(
                id = "c3b9f0da-6e3d-4edf-b903-a698412355ea",
                bibNumber = "201",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:58.150+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "ad18d657-c51c-4679-87b0-a724aaec0bd6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.182+00:00",
                        runners = null,
                        sicard = "8055521",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Lene Garcia Schulze",
                        stageResult = RemoteStageResult(
                            id = "0260a9ae-65ee-4c46-85d9-a61f5c086cf3",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:40:00.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 780,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:58.189+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "c6c70317-1fb1-4f6f-beb7-84247ea81b4d",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.363+00:00",
                        runners = null,
                        sicard = "8541524",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Eki Beobide Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "24ac73f7-8d42-4673-a715-5c9d2d87cfca",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:40:00.000+00:00",
                            finishTime = "2026-06-22T07:47:35.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 455,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:58.372+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "d5fca51d-aad0-49e4-8656-418cdcaf18cd",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.517+00:00",
                        runners = null,
                        sicard = "8073959",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Alain Goikoetxea Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "208e6f05-db15-4aec-ba17-7cd6940608ef",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:47:35.000+00:00",
                            finishTime = "2026-06-22T07:55:50.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 494,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:58.524+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "e8c057d3-b7f8-43c1-8ce9-cae111aa14f9",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.719+00:00",
                        runners = null,
                        sicard = "8522467",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Haizea Leizaola Lizaso",
                        stageResult = RemoteStageResult(
                            id = "dd512fc9-6448-41dd-a741-bf1ee72b22f7",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:50.000+00:00",
                            finishTime = "2026-06-22T08:06:00.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 610,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:12:58.726+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                    shortName = "EUSKADI"
                ),
                fullName = "EUSKADI A",
                stageResult = RemoteStageResult(
                    id = "92a32dda-0f7f-4141-995b-a838629d10ec",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:06:00.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2340,
                    position = 2,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 54,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:58.174+00:00",
                    splits = emptyList()
                ),
                overalls = null
            )
        )
    )

    val teamRanksMP = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "44cc47e5-93f0-4ce2-9b72-de3d830410c1",
                bibNumber = "203",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:13:01.474+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "d4a51153-cb40-4b4d-8a26-8c34d856c114",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:13:01.494+00:00",
                        runners = null,
                        sicard = "8655862",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "c888bfe8-16e3-4a86-b40a-f401ea56bc8f",
                            shortName = "GALICIA"
                        ),
                        fullName = "Jana Albarran Oroza",
                        stageResult = RemoteStageResult(
                            id = "321db4a6-3c39-491f-b63e-b206f7e90e23",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:37:39.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 639,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:13:01.497+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "c0fbc0e8-eb35-406c-8bad-da0ae0a4197a",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:13:01.639+00:00",
                        runners = null,
                        sicard = "8655857",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "c888bfe8-16e3-4a86-b40a-f401ea56bc8f",
                            shortName = "GALICIA"
                        ),
                        fullName = "Anton Rodriguez Seijo",
                        stageResult = RemoteStageResult(
                            id = "420ccd6c-ed02-443c-9162-0a41dab81f5b",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:37:39.000+00:00",
                            finishTime = "2026-06-22T07:48:24.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 644,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:13:01.647+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "dd01506f-0c8c-4f8d-9182-2d6900366343",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:13:01.800+00:00",
                        runners = null,
                        sicard = "8655858",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "c888bfe8-16e3-4a86-b40a-f401ea56bc8f",
                            shortName = "GALICIA"
                        ),
                        fullName = "Iago Rodriguez Seijo",
                        stageResult = RemoteStageResult(
                            id = "23f09f7a-260e-44bc-9c58-105c72273982",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:48:24.000+00:00",
                            finishTime = "2026-06-22T07:59:27.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 662,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:13:01.808+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "ccff931b-ac6a-4119-a590-fac0e754e9ab",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:13:01.975+00:00",
                        runners = null,
                        sicard = "8655863",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "c888bfe8-16e3-4a86-b40a-f401ea56bc8f",
                            shortName = "GALICIA"
                        ),
                        fullName = "Sabela Pérez Pastoriza",
                        stageResult = RemoteStageResult(
                            id = "f33037a3-e896-49ad-a476-d89fd40cbf2d",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:59:27.000+00:00",
                            finishTime = "2026-06-22T08:09:58.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 631,
                            position = 0,
                            statusCode = "3",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:13:01.983+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "c888bfe8-16e3-4a86-b40a-f401ea56bc8f",
                    shortName = "GALICIA"
                ),
                fullName = "GALICIA A",
                stageResult = RemoteStageResult(
                    id = "c6b02637-5e8f-48a8-9d34-21d3747052f1",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:09:58.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2286,
                    position = 1,
                    statusCode = "3",
                    isNc = false,
                    contributory = null,
                    timeBehind = 0,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:59.525+00:00",
                    splits = emptyList()
                ),
                overalls = null
            ),
            RemoteResult(
                id = "c3b9f0da-6e3d-4edf-b903-a698412355ea",
                bibNumber = "201",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:58.150+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "ad18d657-c51c-4679-87b0-a724aaec0bd6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.182+00:00",
                        runners = null,
                        sicard = "8055521",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Lene Garcia Schulze",
                        stageResult = RemoteStageResult(
                            id = "0260a9ae-65ee-4c46-85d9-a61f5c086cf3",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:40:00.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 780,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:58.189+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "c6c70317-1fb1-4f6f-beb7-84247ea81b4d",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.363+00:00",
                        runners = null,
                        sicard = "8541524",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Eki Beobide Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "24ac73f7-8d42-4673-a715-5c9d2d87cfca",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:40:00.000+00:00",
                            finishTime = "2026-06-22T07:47:35.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 455,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:58.372+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "d5fca51d-aad0-49e4-8656-418cdcaf18cd",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.517+00:00",
                        runners = null,
                        sicard = "8073959",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Alain Goikoetxea Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "208e6f05-db15-4aec-ba17-7cd6940608ef",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:47:35.000+00:00",
                            finishTime = "2026-06-22T07:55:50.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 494,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:58.524+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "e8c057d3-b7f8-43c1-8ce9-cae111aa14f9",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.719+00:00",
                        runners = null,
                        sicard = "8522467",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Haizea Leizaola Lizaso",
                        stageResult = RemoteStageResult(
                            id = "dd512fc9-6448-41dd-a741-bf1ee72b22f7",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:50.000+00:00",
                            finishTime = "2026-06-22T08:06:00.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 610,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:12:58.726+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                    shortName = "EUSKADI"
                ),
                fullName = "EUSKADI A",
                stageResult = RemoteStageResult(
                    id = "92a32dda-0f7f-4141-995b-a838629d10ec",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:06:00.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2340,
                    position = 2,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 54,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:58.174+00:00",
                    splits = emptyList()
                ),
                overalls = null
            )
        )
    )

    val teamRanksNC = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "8cc0b48c-942a-4582-a461-5d5660b0142f",
                bibNumber = "202",
                isNc = true,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:59.505+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "2a11fd65-8d9e-4238-b64a-0e123bc191f6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.534+00:00",
                        runners = null,
                        sicard = "8291111",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Marta Nogués Vives",
                        stageResult = RemoteStageResult(
                            id = "63e9ecea-7934-4751-b624-bd67b2942aab",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:38:25.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 685,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:59.545+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "01d3e13d-e3f8-4970-abd9-2306c6ef328c",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.708+00:00",
                        runners = null,
                        sicard = "8328677",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Joel Rufo Franch",
                        stageResult = RemoteStageResult(
                            id = "831e04fd-766e-4b88-a952-f2bff43dc3ce",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:38:25.000+00:00",
                            finishTime = "2026-06-22T07:46:46.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 500,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:59.716+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "b21e193a-62b5-4d9a-9c62-3c3a8240c134",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.863+00:00",
                        runners = null,
                        sicard = "8511773",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Martí Hernandez Oliveras",
                        stageResult = RemoteStageResult(
                            id = "cd45fe2e-1213-4b5a-ac3d-959e1485378a",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:46:46.000+00:00",
                            finishTime = "2026-06-22T07:55:36.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 530,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:59.870+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "f7890230-4491-4d71-87e5-25ccb5b02c12",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:13:00.004+00:00",
                        runners = null,
                        sicard = "8513878",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Sira Font Torrentó",
                        stageResult = RemoteStageResult(
                            id = "8e904a41-efdf-4548-bc14-d167510c8c02",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:36.000+00:00",
                            finishTime = "2026-06-22T08:05:06.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 569,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:13:00.011+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                    shortName = "CATALUNYA"
                ),
                fullName = "CATALUNYA A",
                stageResult = RemoteStageResult(
                    id = "e25f0cc4-dfdd-47da-bffd-e0ca8aa68e7b",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:05:06.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2286,
                    position = 1,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 0,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:59.525+00:00",
                    splits = emptyList()
                ),
                overalls = null
            ),
            RemoteResult(
                id = "c3b9f0da-6e3d-4edf-b903-a698412355ea",
                bibNumber = "201",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:58.150+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "ad18d657-c51c-4679-87b0-a724aaec0bd6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.182+00:00",
                        runners = null,
                        sicard = "8055521",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Lene Garcia Schulze",
                        stageResult = RemoteStageResult(
                            id = "0260a9ae-65ee-4c46-85d9-a61f5c086cf3",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:40:00.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 780,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:58.189+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "c6c70317-1fb1-4f6f-beb7-84247ea81b4d",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.363+00:00",
                        runners = null,
                        sicard = "8541524",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Eki Beobide Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "24ac73f7-8d42-4673-a715-5c9d2d87cfca",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:40:00.000+00:00",
                            finishTime = "2026-06-22T07:47:35.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 455,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:58.372+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "d5fca51d-aad0-49e4-8656-418cdcaf18cd",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.517+00:00",
                        runners = null,
                        sicard = "8073959",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Alain Goikoetxea Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "208e6f05-db15-4aec-ba17-7cd6940608ef",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:47:35.000+00:00",
                            finishTime = "2026-06-22T07:55:50.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 494,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:58.524+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "e8c057d3-b7f8-43c1-8ce9-cae111aa14f9",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.719+00:00",
                        runners = null,
                        sicard = "8522467",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Haizea Leizaola Lizaso",
                        stageResult = RemoteStageResult(
                            id = "dd512fc9-6448-41dd-a741-bf1ee72b22f7",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:50.000+00:00",
                            finishTime = "2026-06-22T08:06:00.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 610,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:12:58.726+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                    shortName = "EUSKADI"
                ),
                fullName = "EUSKADI A",
                stageResult = RemoteStageResult(
                    id = "92a32dda-0f7f-4141-995b-a838629d10ec",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:06:00.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2340,
                    position = 2,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 54,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:58.174+00:00",
                    splits = emptyList()
                ),
                overalls = null
            )
        )
    )

    val teamRanksFullNC = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "8cc0b48c-942a-4582-a461-5d5660b0142f",
                bibNumber = "202",
                isNc = true,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:59.505+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "2a11fd65-8d9e-4238-b64a-0e123bc191f6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.534+00:00",
                        runners = null,
                        sicard = "8291111",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Marta Nogués Vives",
                        stageResult = RemoteStageResult(
                            id = "63e9ecea-7934-4751-b624-bd67b2942aab",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:38:25.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 685,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:59.545+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "01d3e13d-e3f8-4970-abd9-2306c6ef328c",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.708+00:00",
                        runners = null,
                        sicard = "8328677",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Joel Rufo Franch",
                        stageResult = RemoteStageResult(
                            id = "831e04fd-766e-4b88-a952-f2bff43dc3ce",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:38:25.000+00:00",
                            finishTime = "2026-06-22T07:46:46.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 500,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:59.716+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "b21e193a-62b5-4d9a-9c62-3c3a8240c134",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.863+00:00",
                        runners = null,
                        sicard = "8511773",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Martí Hernandez Oliveras",
                        stageResult = RemoteStageResult(
                            id = "cd45fe2e-1213-4b5a-ac3d-959e1485378a",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:46:46.000+00:00",
                            finishTime = "2026-06-22T07:55:36.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 530,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:59.870+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "f7890230-4491-4d71-87e5-25ccb5b02c12",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:13:00.004+00:00",
                        runners = null,
                        sicard = "8513878",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Sira Font Torrentó",
                        stageResult = RemoteStageResult(
                            id = "8e904a41-efdf-4548-bc14-d167510c8c02",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:36.000+00:00",
                            finishTime = "2026-06-22T08:05:06.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 569,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:13:00.011+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                    shortName = "CATALUNYA"
                ),
                fullName = "CATALUNYA A",
                stageResult = RemoteStageResult(
                    id = "e25f0cc4-dfdd-47da-bffd-e0ca8aa68e7b",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:05:06.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2286,
                    position = 1,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 0,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:59.525+00:00",
                    splits = emptyList()
                ),
                overalls = null
            ),
            RemoteResult(
                id = "c3b9f0da-6e3d-4edf-b903-a698412355ea",
                bibNumber = "201",
                isNc = true,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:58.150+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "ad18d657-c51c-4679-87b0-a724aaec0bd6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.182+00:00",
                        runners = null,
                        sicard = "8055521",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Lene Garcia Schulze",
                        stageResult = RemoteStageResult(
                            id = "0260a9ae-65ee-4c46-85d9-a61f5c086cf3",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:40:00.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 780,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:58.189+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "c6c70317-1fb1-4f6f-beb7-84247ea81b4d",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.363+00:00",
                        runners = null,
                        sicard = "8541524",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Eki Beobide Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "24ac73f7-8d42-4673-a715-5c9d2d87cfca",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:40:00.000+00:00",
                            finishTime = "2026-06-22T07:47:35.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 455,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:58.372+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "d5fca51d-aad0-49e4-8656-418cdcaf18cd",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.517+00:00",
                        runners = null,
                        sicard = "8073959",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Alain Goikoetxea Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "208e6f05-db15-4aec-ba17-7cd6940608ef",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:47:35.000+00:00",
                            finishTime = "2026-06-22T07:55:50.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 494,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:58.524+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "e8c057d3-b7f8-43c1-8ce9-cae111aa14f9",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.719+00:00",
                        runners = null,
                        sicard = "8522467",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Haizea Leizaola Lizaso",
                        stageResult = RemoteStageResult(
                            id = "dd512fc9-6448-41dd-a741-bf1ee72b22f7",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:50.000+00:00",
                            finishTime = "2026-06-22T08:06:00.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 610,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:12:58.726+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                    shortName = "EUSKADI"
                ),
                fullName = "EUSKADI A",
                stageResult = RemoteStageResult(
                    id = "92a32dda-0f7f-4141-995b-a838629d10ec",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:06:00.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2340,
                    position = 2,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 54,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:58.174+00:00",
                    splits = emptyList()
                ),
                overalls = null
            )
        )
    )

    val teamRanksTie = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "8cc0b48c-942a-4582-a461-5d5660b0142f",
                bibNumber = "202",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:59.505+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "2a11fd65-8d9e-4238-b64a-0e123bc191f6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.534+00:00",
                        runners = null,
                        sicard = "8291111",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Marta Nogués Vives",
                        stageResult = RemoteStageResult(
                            id = "63e9ecea-7934-4751-b624-bd67b2942aab",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:38:25.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 685,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:59.545+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "01d3e13d-e3f8-4970-abd9-2306c6ef328c",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.708+00:00",
                        runners = null,
                        sicard = "8328677",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Joel Rufo Franch",
                        stageResult = RemoteStageResult(
                            id = "831e04fd-766e-4b88-a952-f2bff43dc3ce",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:38:25.000+00:00",
                            finishTime = "2026-06-22T07:46:46.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 500,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:59.716+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "b21e193a-62b5-4d9a-9c62-3c3a8240c134",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.863+00:00",
                        runners = null,
                        sicard = "8511773",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Martí Hernandez Oliveras",
                        stageResult = RemoteStageResult(
                            id = "cd45fe2e-1213-4b5a-ac3d-959e1485378a",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:46:46.000+00:00",
                            finishTime = "2026-06-22T07:55:36.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 530,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:59.870+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "f7890230-4491-4d71-87e5-25ccb5b02c12",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:13:00.004+00:00",
                        runners = null,
                        sicard = "8513878",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Sira Font Torrentó",
                        stageResult = RemoteStageResult(
                            id = "8e904a41-efdf-4548-bc14-d167510c8c02",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:36.000+00:00",
                            finishTime = "2026-06-22T08:05:06.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 569,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:13:00.011+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                    shortName = "CATALUNYA"
                ),
                fullName = "CATALUNYA A",
                stageResult = RemoteStageResult(
                    id = "e25f0cc4-dfdd-47da-bffd-e0ca8aa68e7b",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:05:06.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2286,
                    position = 1,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 0,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:59.525+00:00",
                    splits = emptyList()
                ),
                overalls = null
            ),
            RemoteResult(
                id = "c3b9f0da-6e3d-4edf-b903-a698412355ea",
                bibNumber = "201",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:58.150+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "ad18d657-c51c-4679-87b0-a724aaec0bd6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.182+00:00",
                        runners = null,
                        sicard = "8055521",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Lene Garcia Schulze",
                        stageResult = RemoteStageResult(
                            id = "0260a9ae-65ee-4c46-85d9-a61f5c086cf3",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:38:25.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 685,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:58.189+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "c6c70317-1fb1-4f6f-beb7-84247ea81b4d",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.363+00:00",
                        runners = null,
                        sicard = "8541524",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Eki Beobide Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "24ac73f7-8d42-4673-a715-5c9d2d87cfca",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:38:25.000+00:00",
                            finishTime = "2026-06-22T07:46:46.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 500,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:58.372+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "d5fca51d-aad0-49e4-8656-418cdcaf18cd",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.517+00:00",
                        runners = null,
                        sicard = "8073959",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Alain Goikoetxea Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "208e6f05-db15-4aec-ba17-7cd6940608ef",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:46:46.000+00:00",
                            finishTime = "2026-06-22T07:55:36.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 530,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:58.524+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "e8c057d3-b7f8-43c1-8ce9-cae111aa14f9",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.719+00:00",
                        runners = null,
                        sicard = "8522467",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Haizea Leizaola Lizaso",
                        stageResult = RemoteStageResult(
                            id = "dd512fc9-6448-41dd-a741-bf1ee72b22f7",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:36.000+00:00",
                            finishTime = "2026-06-22T08:05:06.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 569,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:12:58.726+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                    shortName = "EUSKADI"
                ),
                fullName = "EUSKADI A",
                stageResult = RemoteStageResult(
                    id = "92a32dda-0f7f-4141-995b-a838629d10ec",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:05:06.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2286,
                    position = 1,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 54,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:58.174+00:00",
                    splits = emptyList()
                ),
                overalls = null
            )
        )
    )

    val teamRanksMultipleTie = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "8cc0b48c-942a-4582-a461-5d5660b0142f",
                bibNumber = "202",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:59.505+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "2a11fd65-8d9e-4238-b64a-0e123bc191f6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.534+00:00",
                        runners = null,
                        sicard = "8291111",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Marta Nogués Vives",
                        stageResult = RemoteStageResult(
                            id = "63e9ecea-7934-4751-b624-bd67b2942aab",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:38:25.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 675,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:59.545+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "01d3e13d-e3f8-4970-abd9-2306c6ef328c",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.708+00:00",
                        runners = null,
                        sicard = "8328677",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Joel Rufo Franch",
                        stageResult = RemoteStageResult(
                            id = "831e04fd-766e-4b88-a952-f2bff43dc3ce",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:38:25.000+00:00",
                            finishTime = "2026-06-22T07:46:46.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 490,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:59.716+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "b21e193a-62b5-4d9a-9c62-3c3a8240c134",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.863+00:00",
                        runners = null,
                        sicard = "8511773",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Martí Hernandez Oliveras",
                        stageResult = RemoteStageResult(
                            id = "cd45fe2e-1213-4b5a-ac3d-959e1485378a",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:46:46.000+00:00",
                            finishTime = "2026-06-22T07:55:36.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 520,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:59.870+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "f7890230-4491-4d71-87e5-25ccb5b02c12",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:13:00.004+00:00",
                        runners = null,
                        sicard = "8513878",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Sira Font Torrentó",
                        stageResult = RemoteStageResult(
                            id = "8e904a41-efdf-4548-bc14-d167510c8c02",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:36.000+00:00",
                            finishTime = "2026-06-22T08:05:06.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 559,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:13:00.011+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                    shortName = "CATALUNYA"
                ),
                fullName = "CATALUNYA A",
                stageResult = RemoteStageResult(
                    id = "e25f0cc4-dfdd-47da-bffd-e0ca8aa68e7b",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:05:06.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2246,
                    position = 1,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 0,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:59.525+00:00",
                    splits = emptyList()
                ),
                overalls = null
            ),
            RemoteResult(
                id = "8cc0b48c-942a-4582-a461-5d5660b0142f",
                bibNumber = "202",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:59.505+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "2a11fd65-8d9e-4238-b64a-0e123bc191f6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.534+00:00",
                        runners = null,
                        sicard = "8291111",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Marta Nogués Vives",
                        stageResult = RemoteStageResult(
                            id = "63e9ecea-7934-4751-b624-bd67b2942aab",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:38:25.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 685,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:59.545+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "01d3e13d-e3f8-4970-abd9-2306c6ef328c",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.708+00:00",
                        runners = null,
                        sicard = "8328677",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Joel Rufo Franch",
                        stageResult = RemoteStageResult(
                            id = "831e04fd-766e-4b88-a952-f2bff43dc3ce",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:38:25.000+00:00",
                            finishTime = "2026-06-22T07:46:46.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 500,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:59.716+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "b21e193a-62b5-4d9a-9c62-3c3a8240c134",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.863+00:00",
                        runners = null,
                        sicard = "8511773",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Martí Hernandez Oliveras",
                        stageResult = RemoteStageResult(
                            id = "cd45fe2e-1213-4b5a-ac3d-959e1485378a",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:46:46.000+00:00",
                            finishTime = "2026-06-22T07:55:36.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 530,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:59.870+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "f7890230-4491-4d71-87e5-25ccb5b02c12",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:13:00.004+00:00",
                        runners = null,
                        sicard = "8513878",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Sira Font Torrentó",
                        stageResult = RemoteStageResult(
                            id = "8e904a41-efdf-4548-bc14-d167510c8c02",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:36.000+00:00",
                            finishTime = "2026-06-22T08:05:06.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 569,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:13:00.011+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                    shortName = "CATALUNYA"
                ),
                fullName = "CATALUNYA B",
                stageResult = RemoteStageResult(
                    id = "e25f0cc4-dfdd-47da-bffd-e0ca8aa68e7b",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:05:06.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2286,
                    position = 2,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 0,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:59.525+00:00",
                    splits = emptyList()
                ),
                overalls = null
            ),
            RemoteResult(
                id = "c3b9f0da-6e3d-4edf-b903-a698412355ea",
                bibNumber = "201",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:58.150+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "ad18d657-c51c-4679-87b0-a724aaec0bd6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.182+00:00",
                        runners = null,
                        sicard = "8055521",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Lene Garcia Schulze",
                        stageResult = RemoteStageResult(
                            id = "0260a9ae-65ee-4c46-85d9-a61f5c086cf3",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:38:25.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 685,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:58.189+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "c6c70317-1fb1-4f6f-beb7-84247ea81b4d",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.363+00:00",
                        runners = null,
                        sicard = "8541524",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Eki Beobide Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "24ac73f7-8d42-4673-a715-5c9d2d87cfca",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:38:25.000+00:00",
                            finishTime = "2026-06-22T07:46:46.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 500,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:58.372+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "d5fca51d-aad0-49e4-8656-418cdcaf18cd",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.517+00:00",
                        runners = null,
                        sicard = "8073959",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Alain Goikoetxea Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "208e6f05-db15-4aec-ba17-7cd6940608ef",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:46:46.000+00:00",
                            finishTime = "2026-06-22T07:55:36.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 530,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:58.524+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "e8c057d3-b7f8-43c1-8ce9-cae111aa14f9",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.719+00:00",
                        runners = null,
                        sicard = "8522467",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Haizea Leizaola Lizaso",
                        stageResult = RemoteStageResult(
                            id = "dd512fc9-6448-41dd-a741-bf1ee72b22f7",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:36.000+00:00",
                            finishTime = "2026-06-22T08:05:06.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 569,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:12:58.726+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                    shortName = "EUSKADI"
                ),
                fullName = "EUSKADI A",
                stageResult = RemoteStageResult(
                    id = "92a32dda-0f7f-4141-995b-a838629d10ec",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:05:06.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2286,
                    position = 1,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 54,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:58.174+00:00",
                    splits = emptyList()
                ),
                overalls = null
            ),
            RemoteResult(
                id = "c3b9f0da-6e3d-4edf-b903-a698412355ea",
                bibNumber = "201",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:58.150+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "ad18d657-c51c-4679-87b0-a724aaec0bd6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.182+00:00",
                        runners = null,
                        sicard = "8055521",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Lene Garcia Schulze",
                        stageResult = RemoteStageResult(
                            id = "0260a9ae-65ee-4c46-85d9-a61f5c086cf3",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:38:25.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 695,
                            position = 4,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:58.189+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "c6c70317-1fb1-4f6f-beb7-84247ea81b4d",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.363+00:00",
                        runners = null,
                        sicard = "8541524",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Eki Beobide Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "24ac73f7-8d42-4673-a715-5c9d2d87cfca",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:38:25.000+00:00",
                            finishTime = "2026-06-22T07:46:46.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 510,
                            position = 4,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:58.372+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "d5fca51d-aad0-49e4-8656-418cdcaf18cd",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.517+00:00",
                        runners = null,
                        sicard = "8073959",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Alain Goikoetxea Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "208e6f05-db15-4aec-ba17-7cd6940608ef",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:46:46.000+00:00",
                            finishTime = "2026-06-22T07:55:36.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 540,
                            position = 4,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:58.524+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "e8c057d3-b7f8-43c1-8ce9-cae111aa14f9",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.719+00:00",
                        runners = null,
                        sicard = "8522467",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Haizea Leizaola Lizaso",
                        stageResult = RemoteStageResult(
                            id = "dd512fc9-6448-41dd-a741-bf1ee72b22f7",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:36.000+00:00",
                            finishTime = "2026-06-22T08:05:06.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 579,
                            position = 4,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:12:58.726+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                    shortName = "EUSKADI"
                ),
                fullName = "EUSKADI B",
                stageResult = RemoteStageResult(
                    id = "92a32dda-0f7f-4141-995b-a838629d10ec",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:05:06.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2326,
                    position = 4,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 54,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:58.174+00:00",
                    splits = emptyList()
                ),
                overalls = null
            )
        )
    )

    val teamRanksNCStatusCode = RemoteResultsResponse(
        results = listOf(
            RemoteResult(
                id = "8cc0b48c-942a-4582-a461-5d5660b0142f",
                bibNumber = "202",
                isNc = true,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:59.505+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "2a11fd65-8d9e-4238-b64a-0e123bc191f6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.534+00:00",
                        runners = null,
                        sicard = "8291111",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Marta Nogués Vives",
                        stageResult = RemoteStageResult(
                            id = "63e9ecea-7934-4751-b624-bd67b2942aab",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:38:25.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 685,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:59.545+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "01d3e13d-e3f8-4970-abd9-2306c6ef328c",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.708+00:00",
                        runners = null,
                        sicard = "8328677",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Joel Rufo Franch",
                        stageResult = RemoteStageResult(
                            id = "831e04fd-766e-4b88-a952-f2bff43dc3ce",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:38:25.000+00:00",
                            finishTime = "2026-06-22T07:46:46.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 500,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:59.716+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "b21e193a-62b5-4d9a-9c62-3c3a8240c134",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:59.863+00:00",
                        runners = null,
                        sicard = "8511773",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Martí Hernandez Oliveras",
                        stageResult = RemoteStageResult(
                            id = "cd45fe2e-1213-4b5a-ac3d-959e1485378a",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:46:46.000+00:00",
                            finishTime = "2026-06-22T07:55:36.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 530,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:59.870+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "f7890230-4491-4d71-87e5-25ccb5b02c12",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:13:00.004+00:00",
                        runners = null,
                        sicard = "8513878",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                            shortName = "CATALUNYA"
                        ),
                        fullName = "Sira Font Torrentó",
                        stageResult = RemoteStageResult(
                            id = "8e904a41-efdf-4548-bc14-d167510c8c02",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:36.000+00:00",
                            finishTime = "2026-06-22T08:05:06.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 569,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:13:00.011+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "22563d8e-336e-4714-bd9f-cd16820f2852",
                    shortName = "CATALUNYA"
                ),
                fullName = "CATALUNYA A",
                stageResult = RemoteStageResult(
                    id = "e25f0cc4-dfdd-47da-bffd-e0ca8aa68e7b",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:05:06.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2286,
                    position = 1,
                    statusCode = "0",
                    isNc = false,
                    contributory = null,
                    timeBehind = 0,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:59.525+00:00",
                    splits = emptyList()
                ),
                overalls = null
            ),
            RemoteResult(
                id = "c3b9f0da-6e3d-4edf-b903-a698412355ea",
                bibNumber = "201",
                isNc = false,
                eligibility = null,
                legs = null,
                created = "2026-06-22T09:12:58.150+00:00",
                runners = listOf(
                    RemoteResult(
                        id = "ad18d657-c51c-4679-87b0-a724aaec0bd6",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.182+00:00",
                        runners = null,
                        sicard = "8055521",
                        sex = "F",
                        legNumber = 1,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Lene Garcia Schulze",
                        stageResult = RemoteStageResult(
                            id = "0260a9ae-65ee-4c46-85d9-a61f5c086cf3",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:27:00.000+00:00",
                            finishTime = "2026-06-22T07:40:00.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 780,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 1,
                            created = "2026-06-22T09:12:58.189+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "c6c70317-1fb1-4f6f-beb7-84247ea81b4d",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.363+00:00",
                        runners = null,
                        sicard = "8541524",
                        sex = "M",
                        legNumber = 2,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Eki Beobide Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "24ac73f7-8d42-4673-a715-5c9d2d87cfca",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:40:00.000+00:00",
                            finishTime = "2026-06-22T07:47:35.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 455,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 2,
                            created = "2026-06-22T09:12:58.372+00:00",
                            splits = listOf()
                        ),
                        overalls = null,
                    ),
                    RemoteResult(
                        id = "d5fca51d-aad0-49e4-8656-418cdcaf18cd",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.517+00:00",
                        runners = null,
                        sicard = "8073959",
                        sex = "M",
                        legNumber = 3,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Alain Goikoetxea Lertxundi",
                        stageResult = RemoteStageResult(
                            id = "208e6f05-db15-4aec-ba17-7cd6940608ef",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:47:35.000+00:00",
                            finishTime = "2026-06-22T07:55:50.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 494,
                            position = 1,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 3,
                            created = "2026-06-22T09:12:58.524+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    ),
                    RemoteResult(
                        id = "e8c057d3-b7f8-43c1-8ce9-cae111aa14f9",
                        bibNumber = null,
                        isNc = false,
                        eligibility = null,
                        legs = null,
                        created = "2026-06-22T09:12:58.719+00:00",
                        runners = null,
                        sicard = "8522467",
                        sex = "F",
                        legNumber = 4,
                        runnerClass = null,
                        runnerClub = RemoteClub(
                            id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                            shortName = "EUSKADI"
                        ),
                        fullName = "Haizea Leizaola Lizaso",
                        stageResult = RemoteStageResult(
                            id = "dd512fc9-6448-41dd-a741-bf1ee72b22f7",
                            resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                            startTime = "2026-06-22T07:55:50.000+00:00",
                            finishTime = "2026-06-22T08:06:00.000+00:00",
                            uploadType = "res_splits",
                            timeSeconds = 610,
                            position = 2,
                            statusCode = "0",
                            isNc = false,
                            contributory = false,
                            timeBehind = 0,
                            timeNeutralization = 0,
                            timeAdjusted = 0,
                            timePenalty = 0,
                            timeBonus = 0,
                            pointsFinal = "0.0000",
                            pointsBehind = "0.0000",
                            pointsAdjusted = "0.0000",
                            pointsPenalty = "0.0000",
                            pointsBonus = "0.0000",
                            note = null,
                            legNumber = 4,
                            created = "2026-06-22T09:12:58.726+00:00",
                            splits = emptyList()
                        ),
                        overalls = null
                    )
                ),
                sicard = null,
                sex = null,
                legNumber = null,
                runnerClass = RemoteClassResults(
                    id = "9a057ca8-4147-45c1-89ca-976710030ceb",
                    shortName = "CADETE",
                    longName = "CADETE"
                ),
                runnerClub = RemoteClub(
                    id = "cd9bd2f1-e428-4ddd-84b6-c6473d2a4656",
                    shortName = "EUSKADI"
                ),
                fullName = "EUSKADI A",
                stageResult = RemoteStageResult(
                    id = "92a32dda-0f7f-4141-995b-a838629d10ec",
                    resultTypeID = "e4ddfa9d-3347-47e4-9d32-c6c119aeac0e",
                    startTime = "2026-06-22T07:27:00.000+00:00",
                    finishTime = "2026-06-22T08:06:00.000+00:00",
                    uploadType = "res_splits",
                    timeSeconds = 2340,
                    position = 2,
                    statusCode = "9",
                    isNc = false,
                    contributory = null,
                    timeBehind = 54,
                    timeNeutralization = 0,
                    timeAdjusted = 0,
                    timePenalty = 0,
                    timeBonus = 0,
                    pointsFinal = "0.0000",
                    pointsBehind = "0.0000",
                    pointsAdjusted = "0.0000",
                    pointsPenalty = "0.0000",
                    pointsBonus = "0.0000",
                    note = null,
                    legNumber = 4,
                    created = "2026-06-22T09:12:58.174+00:00",
                    splits = emptyList()
                ),
                overalls = null
            )
        )
    )
}
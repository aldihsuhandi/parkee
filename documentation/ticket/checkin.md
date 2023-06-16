### API Specification
| Name   | Value             |
| ------ | ----------------- |
| Path   | /parkee/ticket/in |
| Method | POST              |

# request

## request parameter
| Name        | Type   | Mandatory | Remarks                     |
| ----------- | ------ | --------- | --------------------------- |
| vehicleType | String | Y         | MOBIL/MOTOR                 |
| areaCode    | String | Y         | must be capital letters     |
| plateNumber | String | Y         | numerical, length must be 4 |
| plateCode   | String | Y         | must be capital letters     |

## request example

```json
{
    "vehicleType": "MOTOR",
    "areaCode": "B",
    "plateNumber": "6703",
    "plateCode": "WJF"
}
```

## response parameter

| Name          | Type    | Mandatory | Remarks |
| ------------- | ------- | --------- | ------- |
| ticketNumber  | String  | Y         |         |
| success       | boolean | Y         |         |
| resultCode    | String  | N         |         |
| resultMessage | String  | N         |         |

## response example

```json
{
    "ticketNumber": "09123",
    "success": true
}
```

## Possible result code
| Result Code         | Result Message                                        |
| ------------------- | ----------------------------------------------------- |
| SIMILAR_PLATE_FOUND | vehicle plate number already exist in our parking lot |
| SYSTEM_ERROR        | internal system error                                 |
| PARAM_ILLEGAL       | Parameter illegal                                     |
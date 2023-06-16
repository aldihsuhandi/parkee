| Name   | Value               |
| ------ | ------------------- |
| Path   | /parkee/ticket/info |
| Method | POST                |

# request

## request parameter
| Name         | Type   | Mandatory | Remarks |
| ------------ | ------ | --------- | ------- |
| ticketNumber | String | Y         |         |

## request example

```json
{
    "ticketNumber": "12093"
}
```

## response parameter

| Name          | Type          | Mandatory | Remarks |
| ------------- | ------------- | --------- | ------- |
| ticketInfo    | TicketSummary | Y         |         |
| success       | boolean       | Y         |         |
| resultCode    | String        | N         |         |
| resultMessage | String        | N         |         |

### TicketSummary
| Name         | Type   | Mandatory | Remarks |
| ------------ | ------ | --------- | ------- |
| ticketNumber | String | Y         |         |
| areaCode     | String | Y         |         |
| plateNumber  | String | Y         |         |
| plateCode    | String | Y         |         |
| vehicleType  | String | Y         |         |
| checkInTime  | Date   | Y         |         |
| checkOutTime | Date   | Y         |         |
| price        | Long   | Y         |         |

## response example

```json
{
    "ticket": {
        "ticketNumber": "12039",
        "checkInTime": Date,
        "checkOutTime": Date,
        "price": 9000,
        "vehicleType": "MOTOR",
        "areaCode": "B",
        "plateNumber": "6703",
        "plateCode": "WJF",
    },
    "success": true
}
```

## Possible result code
| Result Code      | Result Message                     |
| ---------------- | ---------------------------------- |
| TICKET_NOT_FOUND | ticket doesn't exist in our system |
| SYSTEM_ERROR     | internal system error              |
| PARAM_ILLEGAL    | Parameter illegal                  |
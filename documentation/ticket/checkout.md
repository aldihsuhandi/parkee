### API Specification
| Name   | Value              |
| ------ | ------------------ |
| Path   | /parkee/ticket/out |
| Method | POST               |

# request

## request parameter
| Name         | Type   | Mandatory | Remarks |
| ------------ | ------ | --------- | ------- |
| ticketNumber | Stirng | Y         |         |

## request example

```json
{
    "ticketNumber": "01923"
}
```

## response parameter

| Name          | Type    | Mandatory | Remarks |
| ------------- | ------- | --------- | ------- |
| success       | boolean | Y         |         |
| resultCode    | String  | N         |         |
| resultMessage | String  | N         |         |

## response example

```json
{
    "success": true
}
```

## Possible result code
| Result Code      | Result Message                     |
| ---------------- | ---------------------------------- |
| TICKET_NOT_FOUND | ticket doesn't exist in our system |
| SYSTEM_ERROR     | internal system error              |
| PARAM_ILLEGAL    | Parameter illegal                  |
import { CheckOutAPIResult } from "@/types/ticket/TicketOut";
import { APICall } from "../APICall";

export const CheckOutAPI = async (ticketNumber: string) => {
  const headers = {
    "Content-Type": "application/json",
    "Accept-Type": "application/json",
  };
  const config = {
    headers: headers,
  };

  const result = await APICall<CheckOutAPIResult>({
    path: "/parkee/ticket/out",
    body: {
      ticketNumber: ticketNumber,
    },
    config: config,
  });

  return result;
};

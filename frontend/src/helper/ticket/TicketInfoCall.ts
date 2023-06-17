import { TicketInfoAPIResult, TicketInfoForm } from "@/types/ticket/TicketInfo";
import { APICall } from "../APICall";

export const TicketInfoAPI = async (ticketNumber: string) => {
  const headers = {
    "Content-Type": "application/json",
    "Accept-Type": "application/json",
  };
  const config = {
    headers: headers,
  };

  const result = await APICall<TicketInfoAPIResult>({
    path: "/parkee/ticket/info",
    body: {
      ticketNumber: ticketNumber,
    },
    config: config,
  });

  return result;
};

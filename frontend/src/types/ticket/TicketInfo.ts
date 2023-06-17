import { BaseAPIResult } from "../RequestResult";

export interface TicketInfoForm {
  ticketNumber: string;
}

export interface TicketSummary {
  ticketNumber: string;
  areaCode: string;
  plateNumber: string;
  plateCode: string;
  vehicleType: string;
  checkInTime: string;
  checkOutTime: string;
  price: bigint;
}

export interface TicketInfoAPIResult extends BaseAPIResult {
  ticketInfo: TicketSummary;
}

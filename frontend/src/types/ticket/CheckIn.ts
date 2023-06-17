import { BaseAPIResult } from "../RequestResult";

export interface CheckInForm {
  vehicleType: string;
  areaCode: string;
  plateNumber: string;
  plateCode: string;
}

export interface CheckInAPIResult extends BaseAPIResult {
  ticketNumber: string;
}

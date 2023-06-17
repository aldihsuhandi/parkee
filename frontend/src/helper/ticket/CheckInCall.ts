import { CheckInAPIResult, CheckInForm } from "@/types/ticket/CheckIn";
import { APICall } from "../APICall";

export const CheckInAPI = async (form: CheckInForm) => {
  const headers = {
    "Content-Type": "application/json",
    "Accept-Type": "application/json",
  };
  const config = {
    headers: headers,
  };

  const result = await APICall<CheckInAPIResult>({
    path: "/parkee/ticket/in",
    body: form,
    config: config,
  });

  return result;
};

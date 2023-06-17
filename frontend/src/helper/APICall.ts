import { URL } from "@/types/Constant";
import { BaseAPIResult } from "@/types/RequestResult";
import axios, { AxiosRequestConfig } from "axios";
import { toast } from "react-toastify";
export const APICall = async <T extends BaseAPIResult>({
  path,
  config,
  body,
}: {
  path: string;
  config: AxiosRequestConfig;
  body?: any;
}) => {
  const url = URL + path;
  try {
    const response = await axios.post<T>(url, body, config);
    switch (response.data.resultCode) {
      case "SYSTEM_ERROR":
      case "PARAM_ILLEGAL":
        toast.error("We Encountered a problem...", {
          position: "top-center",
          autoClose: 3000,
          hideProgressBar: false,
          theme: "colored",
        });
        return undefined;
    }
    return response.data;
  } catch (error: any) {
    if (error.response) {
      if (error.response.status === 500) {
        toast.error("The Server encountered an unexpected condition", {
          position: "top-center",
          autoClose: 3000,
          hideProgressBar: false,
          theme: "colored",
        });
      } else {
        toast.error("We encountered a problem with the server", {
          position: "top-center",
          autoClose: 3000,
          hideProgressBar: false,
          theme: "colored",
        });
      }
    } else if (error.request) {
      toast.error("The System is busy or is offline, please try again later", {
        position: "top-center",
        autoClose: 3000,
        hideProgressBar: false,
        theme: "colored",
      });
    } else {
      toast.error("The System is busy, please try again later", {
        position: "top-center",
        autoClose: 3000,
        hideProgressBar: false,
        theme: "colored",
      });
    }
  }
};

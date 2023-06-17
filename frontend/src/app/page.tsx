"use client";
import { CheckInAPI } from "@/helper/ticket/CheckInCall";
import { DateToFormattedString } from "@/helper/util/DateUtil";
import { CheckInAPIResult, CheckInForm } from "@/types/ticket/CheckIn";
import { Field, useFormik } from "formik";
import { useEffect, useState } from "react";
import * as Yup from "yup";

export default function Home() {
  const [ticketNumber, setTicketNumber] = useState<string>("");
  const [errorMessage, setErrorMessage] = useState<string>("");
  const [clock, setClock] = useState(new Date());

  useEffect(() => {
    const timer = setInterval(() => {
      setClock(new Date());
    }, 1000);

    return () => {
      clearInterval(timer);
    };
  });

  const initialValues: CheckInForm = {
    vehicleType: "MOTOR",
    areaCode: "",
    plateNumber: "",
    plateCode: "",
  };

  const CheckInValidation = Yup.object().shape({
    vehicleType: Yup.string().required("Jenis kendaraan perlu diisi!"),
    areaCode: Yup.string().required("Nomor pelat tidak sesuai format!"),
    plateNumber: Yup.string()
      .length(4, "Nomor pelat tidak sesuai format!")
      .required("Nomor pelat tidak sesuai format!"),
    plateCode: Yup.string().required("Nomor pelat tidak sesuai format!"),
  });

  const CheckInForm = () => {
    const formik = useFormik({
      initialValues: initialValues,
      onSubmit: async (values) => {
        console.log(values);
        const form: CheckInForm = {
          vehicleType: values.vehicleType,
          areaCode: values.areaCode,
          plateNumber: values.plateNumber,
          plateCode: values.plateCode,
        };
        console.log(form);
        const checkInResult: CheckInAPIResult | undefined = await CheckInAPI(
          form
        );
        if (checkInResult) {
          if (checkInResult.success) {
            setTicketNumber(checkInResult.ticketNumber);
            setErrorMessage("");
          } else {
            setErrorMessage(checkInResult.resultMessage);
          }
        }
      },
      validationSchema: CheckInValidation,
    });

    const ErrorMessage = () => {
      const msg = formik.errors.areaCode
        ? formik.errors.areaCode
        : formik.errors.plateCode
        ? formik.errors.plateCode
        : formik.errors.plateNumber
        ? formik.errors.plateNumber
        : errorMessage
        ? errorMessage
        : "";

      if (msg) {
        return <div>{msg}</div>;
      }

      return <></>;
    };

    return (
      <>
        <form onSubmit={formik.handleSubmit} className="w-full">
          <div className="flex w-full items-center justify-center rounded-md border-2 border-solid border-blue-300 p-1">
            <input
              type="text"
              id="areaCode"
              name="areaCode"
              onChange={formik.handleChange}
              value={formik.values.areaCode}
              className="mx-1 h-full w-8 rounded-sm p-1 text-center"
            />
            <input
              type="text"
              id="plateNumber"
              name="plateNumber"
              onChange={formik.handleChange}
              value={formik.values.plateNumber}
              className="mx-1 h-full w-16 rounded-sm p-1 text-center"
            />
            <input
              type="text"
              id="placeCode"
              name="plateCode"
              onChange={formik.handleChange}
              value={formik.values.plateCode}
              className="mx-1 h-full w-12 rounded-sm p-1 text-center"
            />
          </div>
          <ErrorMessage />
          <p>Jenis Kendaraan</p>
          <select
            name="vehicleType"
            id="vehicleType"
            value={formik.values.vehicleType}
            onChange={formik.handleChange}
            className="flex w-1/2 items-center justify-start rounded-sm p-2"
          >
            <option value="MOTOR">Motor</option>
            <option value="MOBIL">Mobil</option>
          </select>
          <button
            type="submit"
            className="my-2 flex w-1/2 items-center justify-center rounded-md bg-red-500 p-2 font-bold text-white"
          >
            Cetak Tiket
          </button>
        </form>
      </>
    );
  };

  return (
    <main className="flex min-h-screen flex-col items-center justify-start ">
      <div className="m-4 flex w-full flex-row items-start justify-start p-3">
        <div className="flex w-2/3 flex-col items-start justify-center border-r-2 border-solid border-gray-300 p-4 ">
          {/* camera */}
          <div className="flex h-[500px] w-full items-end justify-start rounded-md  border-2 border-solid border-gray-300">
            <div className="w-full bg-gray-400 p-3">
              <p>Entry Camera</p>
            </div>
          </div>
          <div className="flex w-full flex-col items-start justify-center px-2 pt-5">
            <p>Plat Nomor Kendaraan (F7)</p>
            {CheckInForm()}
          </div>
        </div>
        <div className="flex h-full w-1/3 flex-col items-start justify-center p-4 pt-3">
          <div className="flex w-full flex-col items-center justify-center">
            <p>{DateToFormattedString(clock)}</p>
            <p>Pintu masuk</p>
          </div>
          <div className="flex w-full flex-col items-center justify-start p-3">
            <div className="flex w-full items-center justify-between">
              <p>Nomor ticket</p>
              <p>{ticketNumber ? ticketNumber : "-"}</p>
            </div>
            <div className="flex w-full items-center justify-between">
              <p>Jenis Parkir</p>
              <p>-</p>
            </div>
            <div className="flex w-full items-center justify-between">
              <p>Member Expired</p>
              <p>-</p>
            </div>
            <div className="flex w-full items-center justify-between">
              <p>Nama Member</p>
              <p>-</p>
            </div>
            <a
              href={`/info/` + ticketNumber}
              className="mt-3 flex w-full items-center justify-center rounded-md bg-blue-500 p-2 text-white"
            >
              Checkout ticket
            </a>
          </div>
        </div>
      </div>
    </main>
  );
}

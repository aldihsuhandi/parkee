"use client";

import { CheckOutAPI } from "@/helper/ticket/CheckOutCall";
import { TicketInfoAPI } from "@/helper/ticket/TicketInfoCall";
import { FormatCurrencyIdrBigInt } from "@/helper/util/CurrencyUtil";
import { DateStrToFormattedString } from "@/helper/util/DateUtil";
import { TicketSummary } from "@/types/ticket/TicketInfo";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function Page({ params }: { params: { ticketNumber: string } }) {
  const [ticket, setTicket] = useState<TicketSummary>();

  const router = useRouter();

  useEffect(() => {
    const ticketInfo = async () => {
      const result = await TicketInfoAPI(params.ticketNumber);
      if (result && result.success) {
        setTicket(result.ticketInfo);
      }
    };

    ticketInfo();
  }, [params.ticketNumber]);

  return (
    <main className="flex min-h-screen flex-col items-center justify-start ">
      <div className="m-4 flex w-full flex-row items-start justify-start p-3">
        <div className="flex w-2/3 flex-col items-start justify-center border-r-2 border-solid border-gray-300 p-4 ">
          <div className="flex h-[500px] w-full items-end justify-start rounded-md  border-2 border-solid border-gray-300">
            <div className="w-full bg-gray-400 p-3">
              <p>Entry Camera</p>
            </div>
          </div>
          <div className="p-3"></div>
          <p>Plate Number</p>
          <div className="flex w-full items-center justify-center rounded-md border-2 border-solid border-gray-300 p-1">
            <div className="px-1">{ticket?.areaCode}</div>
            <div className="px-1">{ticket?.plateNumber}</div>
            <div className="px-1">{ticket?.plateCode}</div>
          </div>
          <div className="p-3"></div>
          <p>Jenis Kendaraan</p>
          <div className="flex w-full items-center justify-center rounded-md border-2 border-solid border-gray-300 p-1">
            <div className="px-1">{ticket?.vehicleType}</div>
          </div>
        </div>
        <div className="flex w-1/3 flex-col items-start justify-center border-r-2 border-solid border-gray-300 p-4 ">
          <div className="flex w-full flex-col items-center justify-center">
            <p>Pintu masuk</p>
          </div>
          <div className="flex w-full flex-col items-center justify-start p-3">
            <div className="flex w-full items-center justify-between">
              <p>Nomor ticket</p>
              <p>{ticket?.ticketNumber}</p>
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
            <div className="flex w-full items-center justify-between">
              <p>Waktu masuk</p>
              <p>
                {ticket && ticket.checkInTime
                  ? DateStrToFormattedString(ticket.checkInTime)
                  : "-"}
              </p>
            </div>
            <div className="flex w-full items-center justify-between">
              <p>Waktu keluar</p>
              <p>
                {ticket && ticket.checkOutTime
                  ? DateStrToFormattedString(ticket.checkOutTime)
                  : "-"}
              </p>
            </div>
            <div className="flex w-full items-center justify-between">
              <p>Total</p>
              <p>
                {ticket && ticket.price
                  ? FormatCurrencyIdrBigInt(ticket.price)
                  : "-"}
              </p>
            </div>

            <button
              onClick={async () => {
                const result = await CheckOutAPI(params.ticketNumber);
                if (result && result.success) {
                  router.push("/");
                }
              }}
              className="mt-3 flex w-full items-center justify-center rounded-md bg-blue-500 p-2 text-white"
            >
              check out
            </button>
          </div>
        </div>
      </div>
    </main>
  );
}

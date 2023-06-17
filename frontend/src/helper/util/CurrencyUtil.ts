export function FormatCurrencyIdrBigInt(number: bigint) {
  const formatter = new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "IDR",
  });

  return formatter.format(number);
}

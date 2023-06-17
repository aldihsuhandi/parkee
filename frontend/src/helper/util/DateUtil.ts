export function DateToFormattedString(date: Date) {
  const formattedDate = date.toLocaleString("en-GB", {
    second: "2-digit",
    minute: "2-digit",
    hour: "2-digit",
    day: "numeric",
    month: "short",
    year: "numeric",
  });

  return formattedDate;
}

export function DateStrToFormattedString(dateStr: string) {
  const date = new Date(dateStr);
  const formattedDate = date.toLocaleString("en-GB", {
    second: "2-digit",
    minute: "2-digit",
    hour: "2-digit",
    day: "numeric",
    month: "short",
    year: "numeric",
  });

  return formattedDate;
}

#!/usr/bin/env node
import * as meow from "meow";
import { convert } from "./convert";

const usageText = `
Convert from one currency to another. Note that the rates are fixed values and therefore inaccurate.

Usage
  $ exchange -i <currency> -o <currency> <amount>

Options
  --input, -i   Input currency
  --output, -o  Output currency

Available Currencies
  
  USD, EUR, GBP, INR, AUD, CAD, JPY

Examples
  $ exchange -i usd -o gbp 4.30
`;

const cliOptions: meow.Options<meow.AnyFlags> = {
  autoHelp: true,
  autoVersion: true,
  inferType: true,
  flags: {
    input: {
      type: "string",
      alias: "i",
      isRequired: true,
    },
    output: {
      type: "string",
      alias: "o",
      isRequired: true,
    },
  },
};

const cli = meow(usageText, cliOptions);

const inCurr: string = (cli.flags.input + "").toLowerCase();
const outCurr: string = (cli.flags.output + "").toLowerCase();
const amount: number = parseFloat(cli.input[0]);
const converted = convert(inCurr, outCurr, amount);

console.log(
  `${amount} ${inCurr.toUpperCase()} -> ${converted} ${outCurr.toUpperCase()}`
);

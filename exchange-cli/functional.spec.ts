import { exec } from "child_process";

const cmd = "node dist/index.js";
// const cmd = "exchange";

describe("functional tests", () => {
  describe("miscellaneous flags", () => {
    it("should print help", async () => {
      // GIVEN the command is available on PATH

      // WHEN the command is run with the help flag
      const res = await runCommand(`${cmd} --help`);

      // THEN the CLI should print help info
      expect(res.stdout).toContain("Convert from one currency to another");

      // AND the command should exit normally
      expect(res.stderr).toBeFalsy();
    });

    it("should check for missing flags", async () => {
      // GIVEN the command is available on PATH

      // WHEN the command is run with no arguments
      try {
        await runCommand(cmd);
        fail();
      } catch (e) {
        expect(e).toContain("Missing required flags");
      }

      // THEN the CLI should print missing args
    });
  });

  describe("conversions", () => {
    it('should do a simple "conversion"', async () => {
      // GIVEN the command is available on PATH

      // WHEN the command is run with `exchange -i usd -o usd 3.5`
      const res = await runCommand(`${cmd} -i usd -o usd 3.5`);

      // THEN the CLI should convert from USD to USD
      expect(res.stdout).toMatch("3.5 USD -> 3.5 USD");

      // AND the command should exit normally
      expect(res.stderr).toBeFalsy();
    });

    it("should convert different currencies", async () => {
      // GIVEN the command is available on PATH

      // WHEN the command is run with `exchange -i usd -o jpy 3.5`
      const res = await runCommand(`${cmd} -i usd -o jpy 3.5`);

      // THEN the CLI should convert between two different currencies
      expect(res.stdout).toMatch("3.5 USD -> 364.6 JPY");

      // AND the command should exit normally
      expect(res.stderr).toBeFalsy();
    });
  });

  async function runCommand(
    cmd: string
  ): Promise<{ stdout: string; stderr: string }> {
    return new Promise((resolve, reject) => {
      exec(cmd, (err, stdout, stderr) => {
        if (err) {
          reject(stderr);
        } else {
          resolve({ stdout, stderr });
        }
      });
    });
  }
});

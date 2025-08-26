# sample-assessment



# Assessment README — Web IDE (Generic)

**Platform:** Web-based IDE (e.g., in-browser editor)  
**Evaluation & Scores:** Posted in the **LMS you’re logged into** after automated checks (and any manual review).  
**Duration:** **90–120 minutes** (may vary by topic/cohort; follow the timer shown in your session).

---

## TL;DR

- This is a **web-based assessment**. You’ll implement **business logic only** in the designated files/area.  
- **Do not** change framework/infra/entrypoint/build config unless explicitly told to.  
- Use the **provided logger** (language-appropriate) for key decisions, branches, and errors.  
- Your **score appears in the LMS** after submission and evaluation.  
- Need help during the attempt? Email **support@docere.pro**.

---

## Environment (pre-configured)

- Language/runtime and basic project setup are preloaded by the platform.  
- You’ll see a starter layout similar to:

```text
domain/     # Data models / types (may be provided)
logic/      # Implement here ✅ (business rules, validations)
infra/      # I/O, adapters, controllers (DO NOT MODIFY)
util/       # Helpers (e.g., Result/Errors/Logger)
main entry  # App/Server entrypoint (DO NOT MODIFY)
build file  # Package/Build config (DO NOT MODIFY)
```

> Your task is to complete the **TODO** markers in the **logic** area only.

---

## What you need to do

1. Open the files marked for **business logic** (look for `// TODO` or comments calling out the required functions).  
2. Implement:
   - Basic **validation** (null/empty, bounds, required fields).
   - **Core computation/rules** as described in the prompt.
   - **Thresholds/bands** and a clear, structured result.
   - **Logging** for milestones, branches, and errors (use the platform/logger utility; avoid raw prints if a logger is provided).
3. _Optional, if time permits:_ Add 1–2 **unit tests** for your core method(s).

---

## Run & Test (inside the web IDE)

Use the **Run** and **Test** buttons if present. If a terminal is available, typical commands are:

| Language | Build | Run | Test |
|---|---|---|---|
| Java | `mvn -q -DskipTests package` | `mvn -q exec:java` | `mvn -q test` |
| Python | _(none)_ | `python main.py` | `pytest -q` |
| Node.js | `npm ci` | `npm start` or `node index.js` | `npm test` |
| C#/.NET | `dotnet build -c Release` | `dotnet run -c Release` | `dotnet test -c Release` |
| Go | _(none)_ | `go run ./...` | `go test ./... -v` |

> Your workspace may be language-specific; follow any on-screen instructions if they differ.

---

## Evaluation (what matters)

- **Correctness & Requirements — 60%**  
- **Design & Separation of Concerns — 30%** (keep logic where it belongs, use clear models, handle errors cleanly)  
- **Clarity & Logging — 10%** (readable names, purposeful logs)

_Unit tests are valued but optional within the time window._

---

## Rules Summary

- **Individual attempt**: no collaboration or content sharing during/after the test.  
- **Stay in the web IDE**: external libraries/tools or internet resources are **not allowed** unless explicitly enabled for your cohort.  
- **Generative AI/code assistants** are **not allowed** unless your cohort’s instructions say otherwise.  
- **Do not modify** infra/controllers/entrypoint/build config unless told to.  
- Platform activity (build/test results, timestamps, etc.) may be **logged** for integrity.

> Full Terms & Conditions are available in the LMS. Starting the assessment indicates your agreement.

---

## Time Management (90–120 minutes)

- **Read & plan — 8–10 min**: Understand requirements; list assumptions & edge cases.  
- **Implement core logic — 60–80 min**: Focus on required functions and validations.  
- **Refine & verify — 15–20 min**: Clean up names, cover branches/edge cases, add logs.  
- **Run tests & finalize — 5–10 min**: Run visible tests; optionally add 1–2 unit tests.  
- **Submit — 2–5 min**: Final run-through, then **Submit**.

_Always follow the countdown visible in your session._

---

## Submission & Results

1. Click **Submit** in the IDE/LMS (autosubmit may occur at time-up).  
2. Scores are posted in the **LMS gradebook** after automated checks (and any manual review).  
3. Retake policy (if any) ap
<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->
pears in your LMS.

---

## Troubleshooting

- Refresh the IDE tab and reopen the assessment.  
- Re-run build/tests to confirm status.  
- If issues persist, email **support@docere.pro** **during the attempt** with a brief description and a screenshot.  
- Extra time/retakes are at the organizer’s discretion based on platform logs.

---

## Contact

- **Support:** support@docere.pro  
- **Organizer:** [Your Organization]

# Java with RDBMS and API Intros Sprint Challenge

**Read these instructions carefully. Understand exactly what is expected _before_ starting this Sprint Challenge.**

This challenge allows you to practice the concepts and techniques learned over the past sprint and apply them in a concrete project. This sprint explored **using RDBMS and APIs in Java**. During this sprint, you studied **SQL, Spring Data, JPA, and Hibernate**. In your challenge this week, you will demonstrate your mastery of these skills by creating **a Java Spring REST API Application**.

This is an individual assessment. All work must be your own. Your challenge score is a measure of your ability to work independently using the material covered through this sprint. You need to demonstrate proficiency in the concepts and objectives introduced and practiced in preceding days.

You are not allowed to collaborate during the sprint challenge. However, you are encouraged to follow the twenty-minute rule and seek support from your TL if you need direction.

_You have **three hours** to complete this challenge. Plan your time accordingly._

## Introduction

This is a basic todo database scheme with users and a todo list. Users have a one to many relationship to todo list. One user can have many todo items while a todo item only matches to one users. CRUD operations are available to display and manipulate this data.

Your final results should look like:

### MVP

<details>
<summary>http://localhost:2019/users/users</summary>

```JSON
[
    {
        "userid": 1,
        "username": "admin",
        "primaryemail": "admin@lambdaschool.local",
        "todos": [
            {
                "createdDate": "2020-04-17 10:30:07",
                "todoid": 2,
                "description": "Give Joe access rights",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:30:07",
                "todoid": 3,
                "description": "Change the color of the home page",
                "completed": false
            }
        ]
    },
    {
        "userid": 4,
        "username": "cinnamon",
        "primaryemail": "cinnamon@lambdaschool.local",
        "todos": [
            {
                "createdDate": "2020-04-17 10:30:07",
                "todoid": 5,
                "description": "Take a nap",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:30:07",
                "todoid": 6,
                "description": "Rearrange my hutch",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:30:07",
                "todoid": 7,
                "description": "Groom my fur",
                "completed": false
            }
        ]
    },
    {
        "userid": 8,
        "username": "barnbarn",
        "primaryemail": "barnbarn@lambdaschool.local",
        "todos": [
            {
                "createdDate": "2020-04-17 10:30:07",
                "todoid": 9,
                "description": "Rearrange my hutch",
                "completed": false
            }
        ]
    },
    {
        "userid": 10,
        "username": "puttat",
        "primaryemail": "puttat@school.lambda",
        "todos": []
    },
    {
        "userid": 11,
        "username": "misskitty",
        "primaryemail": "misskitty@school.lambda",
        "todos": []
    }
]
```

</details>

<details>
<summary>http://localhost:2019/users/user/4</summary>

```JSON
{
    "userid": 4,
    "username": "cinnamon",
    "primaryemail": "cinnamon@lambdaschool.local",
    "todos": [
        {
            "createdDate": "2020-04-17 10:30:07",
            "todoid": 5,
            "description": "Take a nap",
            "completed": false
        },
        {
            "createdDate": "2020-04-17 10:30:07",
            "todoid": 6,
            "description": "Rearrange my hutch",
            "completed": false
        },
        {
            "createdDate": "2020-04-17 10:30:07",
            "todoid": 7,
            "description": "Groom my fur",
            "completed": false
        }
    ]
}
```

</details>

<details>
<summary>POST http://localhost:2019/users/user</summary>

DATA

```JSON
{
    "username": "lambdallama",
    "primaryemail": "llama@lambdaschool.local",
    "password": "ILuvM4th!",
    "todos": [
        {
            "description": "Take over the world"
        },
        {
            "description": "Make lasagna"
        }
    ]
}
```

OUTPUT

```TEXT
No Body

Status 201 Created
Location Header: http://localhost:2019/users/user/12
```

</details>

<details>
<summary>POST http://localhost:2019/todos/user/4</summary>

DATA

```JSON
{
    "description": "Make coffee"
}
```

OUTPUT

```TEXT
No Body

Status 201 Created
Location Header: http://localhost:2019/todos/todo/15
```

</details>

<details>
<summary>PATCH http://localhost:2019/todos/todo/7</summary>

OUTPUT

```TEXT
No Body

Status OK
```

</details>

<details>
<summary>DELETE http://localhost:2019/users/userid/10</summary>

OUTPUT

```TEXT
No Body

Status OK
```

</details>

<details>
<summary>http://localhost:2019/users/users/todos</summary>

```JSON
[
    {
        "usernamerpt": "admin",
        "counttodos": 2
    },
    {
        "usernamerpt": "barnbarn",
        "counttodos": 1
    },
    {
        "usernamerpt": "cinnamon",
        "counttodos": 3
    },
    {
        "usernamerpt": "lambdallama",
        "counttodos": 2
    }
]
```

</details>

### Stretch Goals

<details>
<summary>http://localhost:2019/users/user/cinnamon/todos</summary>

```JSON
{
    "userid": 4,
    "username": "cinnamon",
    "primaryemail": "cinnamon@lambdaschool.local",
    "todos": [
        {
            "createdDate": "2020-04-17 10:30:07",
            "todoid": 5,
            "description": "Take a nap",
            "completed": false
        },
        {
            "createdDate": "2020-04-17 10:30:07",
            "todoid": 6,
            "description": "Rearrange my hutch",
            "completed": false
        },
        {
            "createdDate": "2020-04-17 10:39:45",
            "todoid": 15,
            "description": "Make coffee",
            "completed": false
        }
    ]
}
```

</details>

<details>
<summary>http://localhost:2019/users/users</summary>

```JSON
[
    {
        "userid": 1,
        "username": "admin",
        "primaryemail": "admin@lambdaschool.local",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 2,
                "description": "Give Joe access rights",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 3,
                "description": "Change the color of the home page",
                "completed": false
            }
        ]
    },
    {
        "userid": 4,
        "username": "cinnamon",
        "primaryemail": "cinnamon@lambdaschool.local",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 5,
                "description": "Take a nap",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 6,
                "description": "Rearrange my hutch",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 7,
                "description": "Groom my fur",
                "completed": false
            }
        ]
    },
    {
        "userid": 8,
        "username": "barnbarn",
        "primaryemail": "barnbarn@lambdaschool.local",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 9,
                "description": "Rearrange my hutch",
                "completed": false
            }
        ]
    },
    {
        "userid": 10,
        "username": "puttat",
        "primaryemail": "puttat@school.lambda",
        "todos": []
    },
    {
        "userid": 11,
        "username": "misskitty",
        "primaryemail": "misskitty@school.lambda",
        "todos": []
    },
    {
        "userid": 12,
        "username": "danelle.wiza",
        "primaryemail": "tory.hessel@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 13,
                "description": "Catch Caterpie",
                "completed": false
            }
        ]
    },
    {
        "userid": 14,
        "username": "thuy.watsica",
        "primaryemail": "myrle.bashirian@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 15,
                "description": "Catch Mewtwo",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 16,
                "description": "Catch Jynx",
                "completed": false
            }
        ]
    },
    {
        "userid": 17,
        "username": "lavenia.ondricka",
        "primaryemail": "inell.weissnat@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 18,
                "description": "Catch Kadabra",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 19,
                "description": "Catch Jolteon",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 20,
                "description": "Catch Jynx",
                "completed": false
            }
        ]
    },
    {
        "userid": 21,
        "username": "danielle.rippin",
        "primaryemail": "efren.kovacek@hotmail.com",
        "todos": []
    },
    {
        "userid": 22,
        "username": "wendell.dietrich",
        "primaryemail": "bernardina.kirlin@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 23,
                "description": "Catch Kadabra",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 24,
                "description": "Catch Doduo",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 25,
                "description": "Catch Shellder",
                "completed": false
            }
        ]
    },
    {
        "userid": 26,
        "username": "tom.boyle",
        "primaryemail": "melani.schmidt@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 27,
                "description": "Catch Kabutops",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 28,
                "description": "Catch Magneton",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 29,
                "description": "Catch Omastar",
                "completed": false
            }
        ]
    },
    {
        "userid": 30,
        "username": "sherry.gerhold",
        "primaryemail": "sonya.hettinger@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 31,
                "description": "Catch Sandslash",
                "completed": false
            }
        ]
    },
    {
        "userid": 32,
        "username": "cory.abbott",
        "primaryemail": "sue.ernser@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 33,
                "description": "Catch Vulpix",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 34,
                "description": "Catch Machamp",
                "completed": false
            }
        ]
    },
    {
        "userid": 35,
        "username": "jessia.crist",
        "primaryemail": "zora.bogisich@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 36,
                "description": "Catch Omanyte",
                "completed": false
            }
        ]
    },
    {
        "userid": 37,
        "username": "nell.swift",
        "primaryemail": "nancee.renner@yahoo.com",
        "todos": []
    },
    {
        "userid": 38,
        "username": "diego.wolf",
        "primaryemail": "devona.batz@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 39,
                "description": "Catch Vileplume",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 40,
                "description": "Catch Kabutops",
                "completed": false
            }
        ]
    },
    {
        "userid": 41,
        "username": "rex.greenholt",
        "primaryemail": "shaniqua.zulauf@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 42,
                "description": "Catch Lapras",
                "completed": false
            }
        ]
    },
    {
        "userid": 43,
        "username": "cameron.langworth",
        "primaryemail": "milford.keebler@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 44,
                "description": "Catch Pikachu",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 45,
                "description": "Catch Venonat",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 46,
                "description": "Catch Kakuna",
                "completed": false
            }
        ]
    },
    {
        "userid": 47,
        "username": "moses.donnelly",
        "primaryemail": "burl.schumm@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 48,
                "description": "Catch Hitmonchan",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 49,
                "description": "Catch Zapdos",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 50,
                "description": "Catch Kabutops",
                "completed": false
            }
        ]
    },
    {
        "userid": 51,
        "username": "lovetta.toy",
        "primaryemail": "daniela.considine@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 52,
                "description": "Catch Tentacool",
                "completed": false
            }
        ]
    },
    {
        "userid": 53,
        "username": "lamonica.west",
        "primaryemail": "yajaira.osinski@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 54,
                "description": "Catch Lickitung",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 55,
                "description": "Catch Golem",
                "completed": false
            }
        ]
    },
    {
        "userid": 56,
        "username": "seymour.towne",
        "primaryemail": "dawna.casper@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 57,
                "description": "Catch Raichu",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 58,
                "description": "Catch Dratini",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 59,
                "description": "Catch Dodrio",
                "completed": false
            }
        ]
    },
    {
        "userid": 60,
        "username": "oma.lind",
        "primaryemail": "yolando.jakubowski@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 61,
                "description": "Catch Metapod",
                "completed": false
            }
        ]
    },
    {
        "userid": 62,
        "username": "delilah.franecki",
        "primaryemail": "hollis.moore@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 63,
                "description": "Catch Eevee",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 64,
                "description": "Catch Mr. Mime",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 65,
                "description": "Catch Venusaur",
                "completed": false
            }
        ]
    },
    {
        "userid": 66,
        "username": "francisca.kuvalis",
        "primaryemail": "sterling.okon@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 67,
                "description": "Catch Magikarp",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 68,
                "description": "Catch Snorlax",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 69,
                "description": "Catch Jynx",
                "completed": false
            }
        ]
    },
    {
        "userid": 70,
        "username": "arturo.schultz",
        "primaryemail": "elida.jones@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 71,
                "description": "Catch Nidorino",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 72,
                "description": "Catch Butterfree",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 73,
                "description": "Catch Cloyster",
                "completed": false
            }
        ]
    },
    {
        "userid": 74,
        "username": "georgine.bailey",
        "primaryemail": "ismael.wisoky@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 75,
                "description": "Catch Cloyster",
                "completed": false
            }
        ]
    },
    {
        "userid": 76,
        "username": "vida.prosacco",
        "primaryemail": "rico.buckridge@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 77,
                "description": "Catch Pidgey",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 78,
                "description": "Catch Alakazam",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 79,
                "description": "Catch Bulbasaur",
                "completed": false
            }
        ]
    },
    {
        "userid": 80,
        "username": "shaunte.homenick",
        "primaryemail": "oscar.farrell@gmail.com",
        "todos": []
    },
    {
        "userid": 81,
        "username": "shirley.greenholt",
        "primaryemail": "harvey.lebsack@yahoo.com",
        "todos": []
    },
    {
        "userid": 82,
        "username": "vincent.klein",
        "primaryemail": "damian.graham@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 83,
                "description": "Catch Mewtwo",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 84,
                "description": "Catch Ekans",
                "completed": false
            }
        ]
    },
    {
        "userid": 85,
        "username": "betty.schulist",
        "primaryemail": "despina.gerhold@yahoo.com",
        "todos": []
    },
    {
        "userid": 86,
        "username": "maire.kreiger",
        "primaryemail": "sherrill.littel@gmail.com",
        "todos": []
    },
    {
        "userid": 87,
        "username": "jefferey.champlin",
        "primaryemail": "mckinley.walter@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 88,
                "description": "Catch Oddish",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 89,
                "description": "Catch Kangaskhan",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 90,
                "description": "Catch Krabby",
                "completed": false
            }
        ]
    },
    {
        "userid": 91,
        "username": "lydia.kerluke",
        "primaryemail": "darcy.langworth@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 92,
                "description": "Catch Doduo",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 93,
                "description": "Catch Nidoqueen",
                "completed": false
            }
        ]
    },
    {
        "userid": 94,
        "username": "cristin.kessler",
        "primaryemail": "susanne.ziemann@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 95,
                "description": "Catch Grimer",
                "completed": false
            }
        ]
    },
    {
        "userid": 96,
        "username": "tracy.lindgren",
        "primaryemail": "penney.yundt@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 97,
                "description": "Catch Jigglypuff",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 98,
                "description": "Catch Nidoking",
                "completed": false
            }
        ]
    },
    {
        "userid": 99,
        "username": "garrett.kemmer",
        "primaryemail": "garry.hyatt@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 100,
                "description": "Catch Rhydon",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 101,
                "description": "Catch Machop",
                "completed": false
            }
        ]
    },
    {
        "userid": 102,
        "username": "lilly.brekke",
        "primaryemail": "victor.murray@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 103,
                "description": "Catch Hitmonlee",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 104,
                "description": "Catch Voltorb",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 105,
                "description": "Catch Clefairy",
                "completed": false
            }
        ]
    },
    {
        "userid": 106,
        "username": "aleshia.waters",
        "primaryemail": "juan.kuhlman@gmail.com",
        "todos": []
    },
    {
        "userid": 107,
        "username": "bettina.mohr",
        "primaryemail": "maryalice.marvin@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 108,
                "description": "Catch Venusaur",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 109,
                "description": "Catch Raichu",
                "completed": false
            }
        ]
    },
    {
        "userid": 110,
        "username": "harlan.huels",
        "primaryemail": "ronald.lesch@yahoo.com",
        "todos": []
    },
    {
        "userid": 111,
        "username": "tarsha.stiedemann",
        "primaryemail": "isobel.koch@yahoo.com",
        "todos": []
    },
    {
        "userid": 112,
        "username": "kathryn.lueilwitz",
        "primaryemail": "eloy.kerluke@yahoo.com",
        "todos": []
    },
    {
        "userid": 113,
        "username": "sandy.mccullough",
        "primaryemail": "jacinto.labadie@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 114,
                "description": "Catch Seaking",
                "completed": false
            }
        ]
    },
    {
        "userid": 115,
        "username": "merlin.carroll",
        "primaryemail": "kevin.jakubowski@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 116,
                "description": "Catch Golem",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 117,
                "description": "Catch Horsea",
                "completed": false
            }
        ]
    },
    {
        "userid": 118,
        "username": "queenie.towne",
        "primaryemail": "kristopher.cummerata@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 119,
                "description": "Catch Raticate",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 120,
                "description": "Catch Pidgey",
                "completed": false
            }
        ]
    },
    {
        "userid": 121,
        "username": "derick.parisian",
        "primaryemail": "denver.baumbach@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 122,
                "description": "Catch Rattata",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 123,
                "description": "Catch Cloyster",
                "completed": false
            }
        ]
    },
    {
        "userid": 124,
        "username": "sherwood.blanda",
        "primaryemail": "benjamin.altenwerth@gmail.com",
        "todos": []
    },
    {
        "userid": 125,
        "username": "grover.parisian",
        "primaryemail": "gayle.klein@gmail.com",
        "todos": []
    },
    {
        "userid": 126,
        "username": "bryon.doyle",
        "primaryemail": "melynda.corwin@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 127,
                "description": "Catch Mew",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 128,
                "description": "Catch Magikarp",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 129,
                "description": "Catch Gengar",
                "completed": false
            }
        ]
    },
    {
        "userid": 130,
        "username": "tory.runolfsdottir",
        "primaryemail": "mark.muller@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 131,
                "description": "Catch Pikachu",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 132,
                "description": "Catch Ivysaur",
                "completed": false
            }
        ]
    },
    {
        "userid": 133,
        "username": "dino.deckow",
        "primaryemail": "jessie.padberg@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 134,
                "description": "Catch Jigglypuff",
                "completed": false
            }
        ]
    },
    {
        "userid": 135,
        "username": "tamesha.connelly",
        "primaryemail": "stephnie.hettinger@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 136,
                "description": "Catch Krabby",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 137,
                "description": "Catch Fearow",
                "completed": false
            }
        ]
    },
    {
        "userid": 138,
        "username": "dianna.paucek",
        "primaryemail": "kizzy.runolfsdottir@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 139,
                "description": "Catch Oddish",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 140,
                "description": "Catch Chansey",
                "completed": false
            }
        ]
    },
    {
        "userid": 141,
        "username": "fonda.boehm",
        "primaryemail": "kiana.bailey@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 142,
                "description": "Catch Articuno",
                "completed": false
            }
        ]
    },
    {
        "userid": 143,
        "username": "jere.feest",
        "primaryemail": "noel.casper@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 144,
                "description": "Catch Graveler",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 145,
                "description": "Catch Vileplume",
                "completed": false
            }
        ]
    },
    {
        "userid": 146,
        "username": "korey.johnston",
        "primaryemail": "carmelia.brown@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 147,
                "description": "Catch Ekans",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 148,
                "description": "Catch Pikachu",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 149,
                "description": "Catch Parasect",
                "completed": false
            }
        ]
    },
    {
        "userid": 150,
        "username": "lanette.olson",
        "primaryemail": "alica.rogahn@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 151,
                "description": "Catch Diglett",
                "completed": false
            }
        ]
    },
    {
        "userid": 152,
        "username": "brock.douglas",
        "primaryemail": "dewey.kuhlman@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 153,
                "description": "Catch Charizard",
                "completed": false
            }
        ]
    },
    {
        "userid": 154,
        "username": "rich.orn",
        "primaryemail": "gracia.von@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 155,
                "description": "Catch Alakazam",
                "completed": false
            }
        ]
    },
    {
        "userid": 156,
        "username": "jamey.dubuque",
        "primaryemail": "ned.rice@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 157,
                "description": "Catch Snorlax",
                "completed": false
            }
        ]
    },
    {
        "userid": 158,
        "username": "sarina.steuber",
        "primaryemail": "mistie.emard@yahoo.com",
        "todos": []
    },
    {
        "userid": 159,
        "username": "shamika.braun",
        "primaryemail": "mia.schuster@yahoo.com",
        "todos": []
    },
    {
        "userid": 160,
        "username": "arron.kshlerin",
        "primaryemail": "carri.rosenbaum@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 161,
                "description": "Catch Marowak",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 162,
                "description": "Catch Golem",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 163,
                "description": "Catch Hypno",
                "completed": false
            }
        ]
    },
    {
        "userid": 164,
        "username": "freddy.dubuque",
        "primaryemail": "huey.weimann@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 165,
                "description": "Catch Mewtwo",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 166,
                "description": "Catch Poliwhirl",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 167,
                "description": "Catch Mankey",
                "completed": false
            }
        ]
    },
    {
        "userid": 168,
        "username": "chantay.pfannerstill",
        "primaryemail": "nilsa.satterfield@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 169,
                "description": "Catch Nidoqueen",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 170,
                "description": "Catch Voltorb",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 171,
                "description": "Catch Tentacool",
                "completed": false
            }
        ]
    },
    {
        "userid": 172,
        "username": "jarrett.hessel",
        "primaryemail": "loretta.reichel@hotmail.com",
        "todos": []
    },
    {
        "userid": 173,
        "username": "maynard.corwin",
        "primaryemail": "daren.rutherford@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 174,
                "description": "Catch Omastar",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 175,
                "description": "Catch Omanyte",
                "completed": false
            }
        ]
    },
    {
        "userid": 176,
        "username": "buck.ratke",
        "primaryemail": "karl.kris@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 177,
                "description": "Catch Jolteon",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 178,
                "description": "Catch Hitmonlee",
                "completed": false
            }
        ]
    },
    {
        "userid": 179,
        "username": "dennise.brakus",
        "primaryemail": "bev.hoppe@yahoo.com",
        "todos": []
    },
    {
        "userid": 180,
        "username": "kaylee.wilkinson",
        "primaryemail": "stewart.aufderhar@gmail.com",
        "todos": []
    },
    {
        "userid": 181,
        "username": "leonore.waelchi",
        "primaryemail": "yvone.mclaughlin@hotmail.com",
        "todos": []
    },
    {
        "userid": 182,
        "username": "maricruz.boehm",
        "primaryemail": "geneva.spencer@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 183,
                "description": "Catch Dugtrio",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 184,
                "description": "Catch Voltorb",
                "completed": false
            }
        ]
    },
    {
        "userid": 185,
        "username": "michaele.altenwerth",
        "primaryemail": "cris.keeling@gmail.com",
        "todos": []
    },
    {
        "userid": 186,
        "username": "louis.towne",
        "primaryemail": "joaquina.mclaughlin@yahoo.com",
        "todos": []
    },
    {
        "userid": 187,
        "username": "isidro.hessel",
        "primaryemail": "adolfo.schoen@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 188,
                "description": "Catch Hypno",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 189,
                "description": "Catch Zubat",
                "completed": false
            }
        ]
    },
    {
        "userid": 190,
        "username": "estella.marvin",
        "primaryemail": "justin.west@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 191,
                "description": "Catch Weezing",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 192,
                "description": "Catch Venomoth",
                "completed": false
            }
        ]
    },
    {
        "userid": 193,
        "username": "greg.crist",
        "primaryemail": "heath.durgan@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 194,
                "description": "Catch Rattata",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 195,
                "description": "Catch Pikachu",
                "completed": false
            }
        ]
    },
    {
        "userid": 196,
        "username": "yee.cronin",
        "primaryemail": "buck.watsica@yahoo.com",
        "todos": []
    },
    {
        "userid": 197,
        "username": "tyson.botsford",
        "primaryemail": "carson.king@yahoo.com",
        "todos": []
    },
    {
        "userid": 198,
        "username": "nu.bosco",
        "primaryemail": "markita.stamm@hotmail.com",
        "todos": []
    },
    {
        "userid": 199,
        "username": "lionel.thiel",
        "primaryemail": "raina.marquardt@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 200,
                "description": "Catch Kabuto",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 201,
                "description": "Catch Beedrill",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 202,
                "description": "Catch Exeggutor",
                "completed": false
            }
        ]
    },
    {
        "userid": 203,
        "username": "tyler.wiegand",
        "primaryemail": "lynsey.nader@hotmail.com",
        "todos": []
    },
    {
        "userid": 204,
        "username": "patricia.beer",
        "primaryemail": "brenton.flatley@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 205,
                "description": "Catch Vulpix",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 206,
                "description": "Catch Hypno",
                "completed": false
            }
        ]
    },
    {
        "userid": 207,
        "username": "aura.macejkovic",
        "primaryemail": "humberto.smith@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 208,
                "description": "Catch Haunter",
                "completed": false
            }
        ]
    },
    {
        "userid": 209,
        "username": "jolie.strosin",
        "primaryemail": "alec.schmeler@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 210,
                "description": "Catch Vileplume",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 211,
                "description": "Catch Machoke",
                "completed": false
            }
        ]
    },
    {
        "userid": 212,
        "username": "cecil.russel",
        "primaryemail": "miguel.dickens@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 213,
                "description": "Catch Kadabra",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 214,
                "description": "Catch Psyduck",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 215,
                "description": "Catch Gyarados",
                "completed": false
            }
        ]
    },
    {
        "userid": 216,
        "username": "austin.mccullough",
        "primaryemail": "marc.bogisich@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 217,
                "description": "Catch Pidgey",
                "completed": false
            }
        ]
    },
    {
        "userid": 218,
        "username": "rocky.romaguera",
        "primaryemail": "taylor.pfeffer@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 219,
                "description": "Catch Magneton",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 220,
                "description": "Catch Magnemite",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 221,
                "description": "Catch Mankey",
                "completed": false
            }
        ]
    },
    {
        "userid": 222,
        "username": "julie.bode",
        "primaryemail": "sebastian.hills@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 223,
                "description": "Catch Psyduck",
                "completed": false
            }
        ]
    },
    {
        "userid": 224,
        "username": "les.dicki",
        "primaryemail": "lavada.grant@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 225,
                "description": "Catch Pidgeot",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 226,
                "description": "Catch Tangela",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 227,
                "description": "Catch Oddish",
                "completed": false
            }
        ]
    },
    {
        "userid": 228,
        "username": "marc.wehner",
        "primaryemail": "michelle.lynch@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 229,
                "description": "Catch Exeggutor",
                "completed": false
            }
        ]
    },
    {
        "userid": 230,
        "username": "jeannetta.parker",
        "primaryemail": "jeremy.thiel@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 231,
                "description": "Catch Victreebel",
                "completed": false
            }
        ]
    },
    {
        "userid": 232,
        "username": "clarisa.bogisich",
        "primaryemail": "dorris.hilpert@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:19",
                "todoid": 233,
                "description": "Catch Mankey",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 234,
                "description": "Catch Diglett",
                "completed": false
            }
        ]
    },
    {
        "userid": 235,
        "username": "jacquetta.hayes",
        "primaryemail": "tracy.hilll@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 236,
                "description": "Catch Jolteon",
                "completed": false
            }
        ]
    },
    {
        "userid": 237,
        "username": "connie.ebert",
        "primaryemail": "dorian.von@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 238,
                "description": "Catch Magikarp",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 239,
                "description": "Catch Gyarados",
                "completed": false
            }
        ]
    },
    {
        "userid": 240,
        "username": "geoffrey.graham",
        "primaryemail": "adolph.spencer@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 241,
                "description": "Catch Horsea",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 242,
                "description": "Catch Machop",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 243,
                "description": "Catch Weedle",
                "completed": false
            }
        ]
    },
    {
        "userid": 244,
        "username": "cheree.franecki",
        "primaryemail": "bettyann.halvorson@hotmail.com",
        "todos": []
    },
    {
        "userid": 245,
        "username": "sharell.adams",
        "primaryemail": "wei.dickens@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 246,
                "description": "Catch Moltres",
                "completed": false
            }
        ]
    },
    {
        "userid": 247,
        "username": "carlos.zboncak",
        "primaryemail": "ross.thompson@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 248,
                "description": "Catch Dodrio",
                "completed": false
            }
        ]
    },
    {
        "userid": 249,
        "username": "fredrick.hammes",
        "primaryemail": "lyndon.gorczany@yahoo.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 250,
                "description": "Catch Nidorina",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 251,
                "description": "Catch Venusaur",
                "completed": false
            }
        ]
    },
    {
        "userid": 252,
        "username": "kiana.mante",
        "primaryemail": "isa.lind@gmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 253,
                "description": "Catch Staryu",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 254,
                "description": "Catch Rhyhorn",
                "completed": false
            }
        ]
    },
    {
        "userid": 255,
        "username": "lydia.schamberger",
        "primaryemail": "roman.jakubowski@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 256,
                "description": "Catch Pidgey",
                "completed": false
            },
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 257,
                "description": "Catch Nidorino",
                "completed": false
            }
        ]
    },
    {
        "userid": 258,
        "username": "lavona.gerhold",
        "primaryemail": "magan.price@hotmail.com",
        "todos": [
            {
                "createdDate": "2020-04-17 10:48:20",
                "todoid": 259,
                "description": "Catch Electabuzz",
                "completed": false
            }
        ]
    }
]
```

</details>

[PDF of Swagger Documentation from http://localhost:2019/swagger-ui.html](https://drive.google.com/open?id=1GMbkcalznXWzuItP4GfmuF7uUj9jftWM)

### Commits

Commit your code regularly and meaningfully. This helps both you (in case you ever need to return to old code for any number of reasons) and your team lead as the evaluate your solution.

Be prepared to demonstrate your understanding of this week's concepts by answering questions on the following topics. You might prepare by writing down your own answers before hand.

1. Explain what an RDBMS is including details the parts of its databases.
2. What are CRUD Operations and how do they relate to SQL and Http Methods?
3. What are examples of relationships between tables?
4. Explain the uses and differences of Spring JPA, Spring Data, and Hibernate.

## Instructions

### Task 1: Project Set Up

- [ ] Create a forked copy of this project
- [ ] Add your team lead as collaborator on Github
- [ ] Clone your OWN version of the repository (Not Lambda's by mistake!)
- [ ] Create a new branch: git checkout -b `<firstName-lastName>`.
- [ ] Create a new Java Spring Application using IntelliJ.
- [ ] Push commits: `git push origin <firstName-lastName>`
- [ ] Implement the project on your newly created `<firstName-lastName>` branch, committing changes regularly
- [ ] Push commits: git push origin `<firstName-lastName>`

### Task 2: Project Requirements

You will be creating a REST api service to store and read data from an H2 database.

- [ ] Please fork and clone this repository. This repository does not have a starter project, so create one inside of the cloned repository folder. Regularly commit and push your code as appropriate.

- [ ] Create the models, repositories, and services needed to model the following suggested table layout:

- Note these are the minimum fields required. More is okay.

- [ ] TODOS
  - `todoid` primary key, not null long
  - `description` string, not null
  - `completed` boolean. Note that for all new todos, default completed to false
  - `userid` foreign key (one user to many todos) not null
  - any time TODOS are displayed, the created on auditing field should also be displayed!

- [ ] USERS
  - `userid` primary key, not null long
  - `username` string, not null unique, always lower case
  - `primaryemail` string, not null unique
  - `password` string, not null. This will be stored in plain text for now.

- [ ] Notes:
  - USERS have a one to many relationship with TODOS.
  - All tables must have the standard 4 auditing fields in place and working, being populated: created on, created by, last modified on, last modified by. The auditing usernames will all default to `llama`.

- [ ] SeedData.java is a sample script that can be modified to populate the database. However, this is the seed data to use for this application. The structure can change, the data should not change. Do populate the database with this data.

- [ ] For all dates use the format `yyyy-MM-dd HH:mm:ss` so `2020-04-15 23:59:59`

Expose the following end points

- [ ] GET /users/users - return all of the users and their todos

- [ ] GET /users/user/{userid} - return the user and their todos based off of id

- [ ] POST /users/user - adds a user.

  You can use the following to test this!

  ```JSON
  {
      "username": "lambdallama",
      "primaryemail": "llama@lambdaschool.local",
      "password": "ILuvM4th!",
      "todos": [
          {
              "description": "Take over the world"
          },
          {
              "description": "Make lasagna"
          }
      ]
  }
  ```

  </details>

- [ ] POST /todos/user/{userid} - adds a todo to the user.

  You can use the following to test this!

  ```JSON
  {
    "description": "Make coffee"
  }
  ```

- [ ] PATCH /todos/todo/{todoid} - mark a todo as completed.

- [ ] DELETE /users/userid/{userid} - Deletes a user based off of their userid and deletes all their associated todos.

- [ ] GET /users/users/todos - lists the number of todos each user has that are NOT completed. Use a custom query to accomplish this!
  - Users with 0 todos do NOT have to be included in the list
  - Order the list by username!

### Required best practices

- [ ] Consistent naming. Examples: variables, functions, Components, and file/folder organization.
- [ ] Consistent spacing. Examples: line breaks, around arguments and before/after functions.
- [ ] Consistent quotation usage.
- [ ] Spell-check.
- [ ] Schedule time to review, refine and reassess your work.

It is better to submit a challenge that meets [MVP](https://en.wikipedia.org/wiki/Minimum_viable_product) than one that attempts too much and fails.

### Tips and Gotchas

In your solution, it is essential that you follow best practices and produce clean and professional results. You will be scored on your adherence to proper code style and good organization. Schedule time to review, refine, and assess your work and perform basic professional polishing including spell-checking and grammar-checking on your work. It is better to submit a challenge that meets MVP than one that attempts too much and does not.

### Task 3: Stretch Goals

- [ ] Add the endpoint GET /users/user/{username}/todos - returns in created date (from auditing fields) order all of the todos that have not yet been completed for the user with the given the username. In other words, what does this user still need to do?
  
- [ ] Add in 100 more random users each with a random number (0 - 3) of random todos. The todos descriptions should be something random as well. For my example, I picked Pokemon names!
  
- [ ] Add Default Swagger Documentation

# Generated by Django 3.1.4 on 2020-12-14 13:31

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('piantala', '0002_auto_20201214_1429'),
    ]

    operations = [
        migrations.AlterField(
            model_name='profileuser',
            name='image',
            field=models.ImageField(blank=True, upload_to='profile_image'),
        ),
    ]